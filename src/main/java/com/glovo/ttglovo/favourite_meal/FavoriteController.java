package com.glovo.ttglovo.favourite_meal;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/addMeal")
    public ResponseEntity<Void> addFavMeal(@RequestBody FavoriteDao favoriteDao, @RequestHeader("Authorization") String token) {
        favoriteService.addFavMeal(favoriteDao, token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
