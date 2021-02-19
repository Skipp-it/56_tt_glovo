package com.glovo.ttglovo.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<RecipeItem, Long> {

}
