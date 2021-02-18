package com.glovo.ttglovo.prices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    public List<Meal> getAllMealPrices() {
        return mealRepository.findAll();
    }

    public Meal getById(Long id) {
        return mealRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("nu merge"));
    }

    public void addPrice(Meal meal) {
        mealRepository.save(meal);
    }
}
