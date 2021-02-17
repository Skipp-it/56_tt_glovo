package com.glovo.ttglovo.favourite_meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFavMealRepository extends JpaRepository<UserFavMeal, Long> {

    Optional<UserFavMeal> findById(Long aLong);
}
