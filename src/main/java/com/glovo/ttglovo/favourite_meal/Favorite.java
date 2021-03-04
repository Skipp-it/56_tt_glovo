package com.glovo.ttglovo.favourite_meal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glovo.ttglovo.Meal.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


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
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "favorite_user_id_fk"))
    private AppUser user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id", foreignKey = @ForeignKey(name = "favorite_meal_id_fk"))
    private Meal meal;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;



    public Favorite(AppUser user, Meal meal,LocalDateTime createdAt ) {
        this.user = user;
        this.meal = meal;
        this.createdAt = createdAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return Objects.equals(id, favorite.id) && Objects.equals(user, favorite.user) && Objects.equals(meal, favorite.meal) && Objects.equals(createdAt, favorite.createdAt);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, user, meal, createdAt);
//    }
}
