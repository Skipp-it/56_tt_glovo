package com.glovo.ttglovo.prices;

import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
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

    public Integer getById(Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow(() -> new FavoriteMealNotFoundException(String.format("Meal with the id=%s not found", id)));
        return meal.getPrice();
    }

    public void addPrice(Meal meal) {
        mealRepository.save(meal);
    }
}
