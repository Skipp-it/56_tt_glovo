package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.prices.Meal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<Long>> getFavMeals(@RequestHeader("Authorization") String token) {
        List<Long> allMeals = favoriteService.getAllMeals(token);
        return ResponseEntity.status(HttpStatus.OK).body(allMeals);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id, @RequestHeader("Authorization") String token) {

        var isRemoved = favoriteService.delete(id,token);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}


