package com.glovo.ttglovo.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findById(Long id);

    List<Meal> findAll();

    //    @Query("SELECT meal.category FROM Meal meal WHERE meal.category =?1")
    @Query(value = "SELECT * FROM meal WHERE category =?1", nativeQuery = true)
    Collection<Meal> findAllByCategory(String category);

}
