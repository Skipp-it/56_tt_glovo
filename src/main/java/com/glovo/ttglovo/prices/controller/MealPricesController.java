package com.glovo.ttglovo.prices.controller;


import com.glovo.ttglovo.prices.service.MealPricesService;
import com.glovo.ttglovo.prices.model.MealPrices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
@CrossOrigin(origins = "http://localhost:3000")
public class MealPricesController {

    private MealPricesService mealPricesService;


    public MealPricesController(MealPricesService mealPricesService) {
        this.mealPricesService = mealPricesService;
    }

    @PostMapping()
    public void addPrice(@RequestBody MealPrices mealPrices) {
        System.out.println(mealPrices);
        mealPricesService.addPrice(mealPrices);
    }

    @GetMapping()
    public List<MealPrices> getAllMealPrices() {
        return mealPricesService.getAllMealPrices();
    }

}
