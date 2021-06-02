package com.glovo.ttglovo.controllers.login;

import com.glovo.ttglovo.exceptions.ExceptionHandling;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserService;
import com.glovo.ttglovo.securityManagement.security.LoginRequest;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/login")
public class AuthController extends ExceptionHandling {

    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;
    private final JwtTokenServices jwtTokenServices;

    @PostMapping()
    public ResponseEntity<?> signin(@RequestBody LoginRequest data) {

        boolean isNonLocked = ((AppUser) appUserService.loadUserByUsername(data.getEmail())).getIsNonLocked();
        if (!isNonLocked){
            throw new LockedException("");
        }
        System.out.println(isNonLocked);
        try {
            String email = data.getEmail();

            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String name = ((AppUser) appUserService.loadUserByUsername(email)).getFirstName();
            Long id = ((AppUser) appUserService.loadUserByUsername(email)).getId();


            String token = jwtTokenServices.createToken(email, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("id", id);
            model.put("name", name);
            model.put("roles", roles);
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }
}

