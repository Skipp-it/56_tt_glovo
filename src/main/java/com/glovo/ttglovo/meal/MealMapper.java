package com.glovo.ttglovo.meal;

import com.glovo.ttglovo.favourite_meal.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MealMapper {


    @Mapping(target = "idMeal", expression = "java(favorite.getMeal().getId())")
    @Mapping(target = "price", expression = "java(favorite.getMeal().getPrice())")
    MealDto mealToMealDto(Favorite favorite);

    @Mapping(target = "idMeal", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category", source = "category")
    MealDto mealToDto(Meal meal);
}
