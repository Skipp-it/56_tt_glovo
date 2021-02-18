package com.glovo.ttglovo.prices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface MealRepository extends CrudRepository<Meal, Long> {

    Optional<Meal> findById(Long id);
}
