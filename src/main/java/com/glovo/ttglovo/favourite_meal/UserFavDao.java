package com.glovo.ttglovo.favourite_meal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavDao {

    private Long appUserId;
    private Long mealId;


}
