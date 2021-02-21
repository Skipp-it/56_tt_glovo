package com.glovo.ttglovo.prices;


import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private  Long mealId;
    private  Integer price;


}
