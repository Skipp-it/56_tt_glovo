package com.glovo.ttglovo.Meal;


import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private Long idMeal;
    private Integer price;
    private String category;
}
