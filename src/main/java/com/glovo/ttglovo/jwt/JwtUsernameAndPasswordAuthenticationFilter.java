package com.glovo.ttglovo.jwt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.glovo.ttglovo.user.User;
import com.glovo.ttglovo.user.UserRepository;
import com.glovo.ttglovo.user.UserService;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
@Autowired
    private UserService userService;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            UsernameAndPasswordAuthenticationRequest authenticationRequest= new ObjectMapper()
                    .readValue(request.getInputStream().readAllBytes(),UsernameAndPasswordAuthenticationRequest.class );
            System.out.println("AUTH REQ-pasul 1 "+authenticationRequest);

            Authentication authentication=new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
            );

             Authentication authenticate= authenticationManager.authenticate(authentication);
            System.out.println("After -pasul2 "+authenticate);
             return authenticate;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetails useru = (UserDetails) authResult.getPrincipal();
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .claim("email", ((User) useru).getEmail())
                .claim("id", ((User) useru).getId())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();

        System.out.println("Token=== " + token);
        response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix()+token);
        response.getWriter().write(
                "{\"" +
                        "id" + "\":\"" + ((User) useru).getId() +"\",\"" +
                     "token"+"\":\""+token+"\",\""+
                     "first_name"+"\":\""+((User) useru).getFirstName()+"\"}"
        );

    }

}
