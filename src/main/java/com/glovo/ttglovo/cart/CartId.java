package com.glovo.ttglovo.cart;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
