package com.glovo.ttglovo.login.controller;

import com.glovo.ttglovo.login.service.LoginService;
import com.glovo.ttglovo.user.model.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public String getCredentialForLogin(@RequestBody User user) {
        return loginService.getUsernameByEmailAndPassword(user).get().getUsername();
    }
}




