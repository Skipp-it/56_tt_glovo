package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "UserFavoriteMeal")
@Table(name = "user_favorite_meal")
public class UserFavMeal {

    @EmbeddedId
    private UserFavMealId id;

    @ManyToOne
    @MapsId("appUserId")
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;


    @ManyToOne
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    private Meal meal;


}
