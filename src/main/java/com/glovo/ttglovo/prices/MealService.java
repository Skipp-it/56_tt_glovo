package com.glovo.ttglovo.prices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@NoArgsConstructor
public class MealService {

    MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void addPrice(Meal meal) {
        mealRepository.save(meal);
    }

    public Optional<Meal> getPrice(Long id) {
        return mealRepository.findById(id);
    }

    public List<Meal> getAllMealPrices() {
        return (List<Meal>) mealRepository.findAll();
    }

}
