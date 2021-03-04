package com.glovo.ttglovo.controllers.mealPrice;


import com.glovo.ttglovo.meal.Meal;
import com.glovo.ttglovo.meal.MealDto;
import com.glovo.ttglovo.meal.MealService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id/{id}")
    public ResponseEntity<Integer> mealPrice(@PathVariable Long id) {
        Integer mealPrice = mealService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mealPrice);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Set<MealDto>> getPricesByCategory(@PathVariable String category) {
        Set<MealDto> mealPricesByCategory = mealService.getPricesByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(mealPricesByCategory);

    }
}
