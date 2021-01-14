package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.prices.model.MealPrices;
import com.glovo.ttglovo.prices.repository.MealPricesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Meal Price Repository Tests")
class MealPricesRepositoryTest {

    @Autowired
    private MealPricesRepository mealPricesRepository;

    @Test
    @DisplayName("Save create mealPrice when successful")
    public void savePersistMealPriceWhenSuccessful() {
        MealPrices mealPrices = createMealPrices();

        MealPrices savedMealPrices = this.mealPricesRepository.save(mealPrices);

        Assertions.assertThat(savedMealPrices.getId()).isNotNull();
        Assertions.assertThat(savedMealPrices.getPrice()).isNotNull();
        Assertions.assertThat(savedMealPrices.getPrice()).isEqualTo(123);

    }


    @Test
    @DisplayName("Save update mealPrice when successful")
    public void saveUpdateMealPriceWhenSuccessful() {
        MealPrices mealPrices = createMealPrices();

        MealPrices savedMealPrices = this.mealPricesRepository.save(mealPrices);

        savedMealPrices.setPrice(1234);

        MealPrices updateMealPrices = this.mealPricesRepository.save(savedMealPrices);

        Assertions.assertThat(savedMealPrices.getId()).isNotNull();
        Assertions.assertThat(savedMealPrices.getPrice()).isNotNull();
        Assertions.assertThat(savedMealPrices.getPrice()).isEqualTo(updateMealPrices.getPrice());

    }


    @Test
    @DisplayName("Delete removes mealPrice when successful")
    public void deleteRemoveMealPriceWhenSuccessful() {
        MealPrices mealPrices = createMealPrices();

        MealPrices savedMealPrices = this.mealPricesRepository.save(mealPrices);

        this.mealPricesRepository.delete(mealPrices);

        Optional<MealPrices> mealPriceOptional = this.mealPricesRepository.findById(savedMealPrices.getId());

        Assertions.assertThat(mealPriceOptional.isEmpty()).isTrue();


    }





    private MealPrices createMealPrices() {
        return new MealPrices(1L, 123);
    }

}