package com.glovo.ttglovo.meal;

import com.glovo.ttglovo.favourite_meal.Favorite;
import com.glovo.ttglovo.meal.MealDto.MealDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-04T23:55:23+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class MealMapperImpl implements MealMapper {

    @Override
    public MealDto mealToMealDto(Favorite favorite) {
        if ( favorite == null ) {
            return null;
        }

        MealDtoBuilder mealDto = MealDto.builder();

        mealDto.idMeal( favorite.getMeal().getId() );
        mealDto.price( favorite.getMeal().getPrice() );

        return mealDto.build();
    }

    @Override
    public MealDto mealToDto(Meal meal) {
        if ( meal == null ) {
            return null;
        }

        MealDtoBuilder mealDto = MealDto.builder();

        mealDto.idMeal( meal.getId() );
        mealDto.price( meal.getPrice() );
        mealDto.category( meal.getCategory() );

        return mealDto.build();
    }
}
