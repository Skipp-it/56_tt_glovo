package com.glovo.ttglovo.securityManagement.security;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserService;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping()
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;
    private final JwtTokenServices jwtTokenServices;

    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginRequest data, HttpServletResponse response) {
        try {
            String email = data.getEmail();

            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String name = ((AppUser) appUserService.loadUserByUsername(email)).getFirstName();
            Long id=((AppUser) appUserService.loadUserByUsername(email)).getId();

            String token = jwtTokenServices.createToken(email, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("id",id);
            model.put("name", name);
            model.put("roles", roles);
            model.put("token", token);
            System.out.println("Token "+token);
//            //add token to cookie
//            Cookie cookie = new Cookie("token", token);
//            cookie.setMaxAge(100);
//            cookie.setHttpOnly(true);
//            response.addCookie(cookie);
//            System.out.println("cookie   " + cookie);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }
}

