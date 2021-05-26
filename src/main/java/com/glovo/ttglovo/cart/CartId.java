package com.glovo.ttglovo.cart;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartId implements Serializable {

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "meal_id")
    @NotNull
    private Long mealId;

    @Override
    public String toString() {
        return "CartId{" +
                "userId=" + userId +
                ", mealId=" + mealId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartId cartId = (CartId) o;
        return Objects.equals(userId, cartId.userId) && Objects.equals(mealId, cartId.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mealId);
    }
}

