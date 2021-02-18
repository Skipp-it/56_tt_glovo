package com.glovo.ttglovo.prices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

    Optional<Meal> findById(Long id);
}
