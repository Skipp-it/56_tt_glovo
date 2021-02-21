package com.glovo.ttglovo.prices;

import com.glovo.ttglovo.favourite_meal.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MealMapper {

//    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    @Mapping(target = "mealId", expression = "java(favorite.getMeal().getId())")
    @Mapping(target = "price", expression = "java(favorite.getMeal().getPrice())")
    MealDto mealToMealDto(Favorite favorite);
}
