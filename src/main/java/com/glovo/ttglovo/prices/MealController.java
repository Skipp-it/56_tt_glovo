package com.glovo.ttglovo.prices;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
@CrossOrigin(origins = "http://localhost:3000")
public class MealController {

    private final MealService mealService;


    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping()
    public void addPrice(@RequestBody Meal meal) {
        System.out.println(meal);
        mealService.addPrice(meal);
    }

    @GetMapping()
    public List<Meal> getAllMealPrices() {
        return mealService.getAllMealPrices();
    }

}
