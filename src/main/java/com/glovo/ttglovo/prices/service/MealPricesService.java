package com.glovo.ttglovo.prices.service;

import com.glovo.ttglovo.prices.repository.MealPricesRepository;
import com.glovo.ttglovo.prices.model.MealPrices;
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
public class MealPricesService {

    MealPricesRepository mealPricesRepository;

    @Autowired
    public MealPricesService(MealPricesRepository mealPricesRepository) {
        this.mealPricesRepository = mealPricesRepository;
    }

    public void addPrice(MealPrices mealPrices) {
        mealPricesRepository.save(mealPrices);
    }

    public Optional<MealPrices> getPrice(Long id) {
        return mealPricesRepository.findById(id);
    }

    public List<MealPrices> getAllMealPrices() {
        return (List<MealPrices>) mealPricesRepository.findAll();
    }

}
