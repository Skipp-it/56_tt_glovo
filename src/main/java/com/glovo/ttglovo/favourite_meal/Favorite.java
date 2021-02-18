package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "Favorite")
@Table(name = "favorite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AppUser user;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    private Meal meal;


    @Override
    public String toString() {
        return "Favorite{" +
                ", user=" + user +
                ", meal=" + meal +
                '}';
    }
}
