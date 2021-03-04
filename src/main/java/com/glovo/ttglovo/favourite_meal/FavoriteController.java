package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.Meal.MealDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/favorite")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/addMeal")
    public ResponseEntity<Void> addFavMeal(@RequestBody FavoriteDto favoriteDto) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        favoriteService.addFavMeal(favoriteDto, principal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Set<MealDto>> getFavMeals() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        Set<MealDto> allMeals = favoriteService.getAllMeals(principal);
        return ResponseEntity.status(HttpStatus.OK).body(allMeals);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean isRemoved = favoriteService.delete(id, principal);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}


