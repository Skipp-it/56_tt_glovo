package com.glovo.ttglovo.securityManagement.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
@Slf4j
public class JwtTokenServices {

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds;

    private final String rolesFieldName = "roles";

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // Creates a JWT token
    public String createToken(String email, List<String> roles) {
        // Add a custom field to the token

        Claims claims = Jwts.claims().setSubject(email);
        claims.put(rolesFieldName, roles);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }


    // checks if the token is valid and not expired.
    public boolean validateToken(String token) {

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.debug("Jwt token invalid " + e);
        }
        return false;
    }

    /**
     * Parses the username and roles from the token. Since the token is signed we can be sure its valid information.
     * Note that it does not make a DB call to be super fast!
     * This could result in returning false data (e.g. the user was deleted, but their token has not expired yet)
     * To prevent errors because of this make sure to check the user in the database for more important calls!
     */
    public Authentication parseUserFromTokenInfo(String token) {
        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        String username = body.getSubject();
        List<String> roles = (List<String>) body.get(rolesFieldName);
        List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return new UsernamePasswordAuthenticationToken(username, "", authorities);
    }

}