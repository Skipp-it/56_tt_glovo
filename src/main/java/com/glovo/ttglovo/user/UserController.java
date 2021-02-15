package com.glovo.ttglovo.user;


import com.glovo.ttglovo.jwt.UsernameAndPasswordAuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor

public class UserController {

  private final UserService userService;





    @PostMapping("/login")
    public String login(@RequestBody UsernameAndPasswordAuthenticationRequest request){
        System.out.println("request "+request);
        return "BAAA";
    }
    @GetMapping("/user/{email}")
    public UserDetails user(@PathVariable String email){

        System.out.println("request "+email);
   return   userService.loadUserByUsername(email);

    }


}
