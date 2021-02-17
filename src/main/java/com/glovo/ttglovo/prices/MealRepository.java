package com.glovo.ttglovo.prices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

}
