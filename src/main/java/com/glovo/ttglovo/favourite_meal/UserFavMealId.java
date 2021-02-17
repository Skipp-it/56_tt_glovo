package com.glovo.ttglovo.favourite_meal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFavMealId implements Serializable {
    @Column(name = "app_user_id")
    private Long appUserId;
    @Column(name = "meal_id")
    private Long mealId;
}
