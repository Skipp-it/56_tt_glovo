package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.meal.Meal;
import com.glovo.ttglovo.meal.MealRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Meal Price Repository Tests")
class MealRepositoryTest {

    @Autowired
    private MealRepository mealRepository;

    @Test
    @DisplayName("Save create mealPrice when successful")
    public void savePersistMealPriceWhenSuccessful() {
        Meal meal = createMealPrices();

        Meal savedMeal = this.mealRepository.save(meal);

        Assertions.assertThat(savedMeal.getId()).isNotNull();
        Assertions.assertThat(savedMeal.getPrice()).isNotNull();
        Assertions.assertThat(savedMeal.getPrice()).isEqualTo(123);

    }


    @Test
    @DisplayName("Save update mealPrice when successful")
    public void saveUpdateMealPriceWhenSuccessful() {
        Meal meal = createMealPrices();

        Meal savedMeal = this.mealRepository.save(meal);

        savedMeal.setPrice(1234);

        Meal updateMeal = this.mealRepository.save(savedMeal);

        Assertions.assertThat(savedMeal.getId()).isNotNull();
        Assertions.assertThat(savedMeal.getPrice()).isNotNull();
        Assertions.assertThat(savedMeal.getPrice()).isEqualTo(updateMeal.getPrice());

    }


    @Test
    @DisplayName("Delete removes mealPrice when successful")
    public void deleteRemoveMealPriceWhenSuccessful() {
        Meal meal = createMealPrices();

        Meal savedMeal = this.mealRepository.save(meal);

        this.mealRepository.delete(meal);

        Optional<Meal> mealPriceOptional = this.mealRepository.findById(savedMeal.getId());

        Assertions.assertThat(mealPriceOptional.isEmpty()).isTrue();


    }





    private Meal createMealPrices() {
        return new Meal(1L, 123);
    }

}