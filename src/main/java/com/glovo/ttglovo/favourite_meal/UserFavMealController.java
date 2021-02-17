package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favoriteMeal")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserFavMealController {

    private final UserFavMealService userFavMealService;
//    private final AuthenticationManager authenticationManager;
    private JwtTokenServices jwtTokenServices;

    @PostMapping("/addMeal")
    public ResponseEntity<Void> addFavMeal(@RequestBody UserFavDao userFavDao, @RequestHeader("Authorization") String token) {
//        userFavMealService.addFavMeal(userFavDao);
        System.out.println(jwtTokenServices.getIdFromToken(token.substring(7)));
        System.out.println("==============" + token.substring(7));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
