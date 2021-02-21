package com.glovo.ttglovo.favourite_meal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.*;

import javax.persistence.*;


@Entity(name = "Favorite")
@Table(name = "favorite")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AppUser user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    private Meal meal;


    public Favorite(AppUser user, Meal meal) {
        this.user = user;
        this.meal = meal;
    }

}
