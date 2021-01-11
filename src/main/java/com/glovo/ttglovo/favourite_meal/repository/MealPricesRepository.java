package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.favourite_meal.model.MealPrices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealPricesRepository extends CrudRepository<MealPrices, Long> {

}
