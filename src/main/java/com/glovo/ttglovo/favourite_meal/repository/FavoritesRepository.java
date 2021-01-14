package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.favourite_meal.model.FavoriteMeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<FavoriteMeal, Long> {
}
