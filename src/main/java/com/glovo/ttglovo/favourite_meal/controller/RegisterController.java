//package com.glovo.ttglovo.favourite_meal.controller;
//
//import com.glovo.ttglovo.favourite_meal.model.User;
//import com.glovo.ttglovo.favourite_meal.service.UserRegisterService;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/register")
//@CrossOrigin(origins = "http://localhost:3000")
//public class RegisterController {
//
//    private final UserRegisterService userRegisterService;
//
//    public RegisterController(UserRegisterService userRegisterService) {
//        this.userRegisterService = userRegisterService;
//    }
//
//    @PostMapping()
//    public boolean addNewUser(@RequestBody User user) {
//        //TODO de adaugat semnal pentru toastify care sa anunte ca nu s-a facut inregistrarea in DB
//
//        return userRegisterService.addNewUser(user);
//    }
//
//}
//
//
//
//
