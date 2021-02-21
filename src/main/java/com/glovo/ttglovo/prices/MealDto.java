package com.glovo.ttglovo.prices;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealDto {
    private Long mealId;
    private Integer price;
}
