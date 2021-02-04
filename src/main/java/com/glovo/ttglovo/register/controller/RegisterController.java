package com.glovo.ttglovo.register.controller;

import com.glovo.ttglovo.user.User;
import com.glovo.ttglovo.user.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public boolean addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

}




