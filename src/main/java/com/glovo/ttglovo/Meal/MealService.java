package com.glovo.ttglovo.Meal;

import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    public Set<MealDto> getAllMealPrices() {
        return mealRepository.findAll().stream()
                .map(mealMapper::mealToDto)
                .collect(Collectors.toSet());
    }

    public Integer getById(Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow(() -> new FavoriteMealNotFoundException(String.format("Meal with the id=%s not found", id)));
        return meal.getPrice();
    }

    public void addPrice(Meal meal) {
        mealRepository.save(meal);
    }

    public Set<MealDto> getPricesByCategory(String category) {
        return mealRepository.findAllByCategory(category).stream()
                .map(mealMapper::mealToDto)
                .collect(Collectors.toSet());
    }
}
