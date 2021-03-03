package com.glovo.ttglovo.securityManagement.registration.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(path = "/register")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        String register = registrationService.register(request);
        return new ResponseEntity<>("User Registration Successful", OK);
    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
