package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "UserFavMeal")
@Table(name = "user_fav_meal")
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

    public UserFavMeal(UserFavMealId id, Meal meal) {
        this.id = id;
        this.meal = meal;
    }
}
