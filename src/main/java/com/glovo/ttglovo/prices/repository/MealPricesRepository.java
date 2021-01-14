package com.glovo.ttglovo.prices.repository;

import com.glovo.ttglovo.prices.model.MealPrices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealPricesRepository extends CrudRepository<MealPrices, Long> {

}
