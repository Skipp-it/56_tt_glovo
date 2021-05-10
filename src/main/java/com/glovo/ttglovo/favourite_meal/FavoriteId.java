package com.glovo.ttglovo.favourite_meal;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FavoriteId implements Serializable {

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @NotNull
    @Column(name = "meal_id")
    private Long mealId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteId that = (FavoriteId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mealId);
    }
}
