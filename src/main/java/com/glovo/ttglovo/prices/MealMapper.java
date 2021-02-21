package com.glovo.ttglovo.prices;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MealMapper {

    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    @Mapping(source = "id", target = "mealId")
    @Mapping(source = "price", target = "price")
    MealDto mealToMealDto(Meal meal);
}
