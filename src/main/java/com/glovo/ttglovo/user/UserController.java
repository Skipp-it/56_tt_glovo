package com.glovo.ttglovo.user;


import com.glovo.ttglovo.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.glovo.ttglovo.jwt.UsernameAndPasswordAuthenticationRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    UserService userService;
    JwtUsernameAndPasswordAuthenticationFilter jwtUsernameAndPasswordAuthenticationFilter;

    @PostMapping("/login")
    public UserDetails login(@RequestBody UsernameAndPasswordAuthenticationRequest request){
        System.out.println("request "+request);
        return userService.loadUserByUsername(request.getEmail());
    }
    @GetMapping("/client")
    public String user(){
        return "MERGEEEE BAAAA, SA TE F..";

    }


}
