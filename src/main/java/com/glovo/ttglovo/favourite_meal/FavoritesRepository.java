package com.glovo.ttglovo.favourite_meal;

import com.glovo.ttglovo.favourite_meal.FavoriteMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoriteMeal, Long> {
}
