package com.glovo.ttglovo.prices;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Meal>> getAllMealPrices() {
        List<Meal> allMealPrices = mealService.getAllMealPrices();
        return ResponseEntity.status(HttpStatus.OK).body(allMealPrices);
    }

    @GetMapping("{id}")
    public ResponseEntity<Integer> mealPrice(@PathVariable Long id) {
        Integer mealPrice = mealService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mealPrice);
    }

}
