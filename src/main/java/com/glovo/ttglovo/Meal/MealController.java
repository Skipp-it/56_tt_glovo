package com.glovo.ttglovo.Meal;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/prices")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class MealController {

    private final MealService mealService;


    @PostMapping()
    public void addPrice(@RequestBody Meal meal) {
        mealService.addPrice(meal);
    }

    @GetMapping()
    public ResponseEntity<Set<MealDto>> getAllMealPrices() {
        Set<MealDto> allMealPrices = mealService.getAllMealPrices();
        return ResponseEntity.status(HttpStatus.OK).body(allMealPrices);
    }

    @GetMapping("{id}")
    public ResponseEntity<Integer> mealPrice(@PathVariable Long id) {
        Integer mealPrice = mealService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mealPrice);
    }

}
