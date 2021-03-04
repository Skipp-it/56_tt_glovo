package com.glovo.ttglovo.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glovo.ttglovo.Meal.Meal;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.*;


import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CartItem")
@Table(name = "cart_items")
public class CartItem {


    @EmbeddedId
    private CartId id;


    @ManyToOne
    @JsonIgnore
    @MapsId("userId")
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("mealId")
    @JoinColumn(
            name = "meal_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "meal_id_fk"
            )
    )
    private Meal meal;

    @Column(
            name = "qty",
            nullable = false,
            columnDefinition = "Integer")
    private Integer quantity;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "Integer",
            updatable = false
    )
    private Integer clientSeenPrice;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", user=" + user +
                ", meal=" + meal +
                ", quantity=" + quantity +
                ", clientSeenPrice=" + clientSeenPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id) && Objects.equals(user, cartItem.user) && Objects.equals(meal, cartItem.meal) && Objects.equals(quantity, cartItem.quantity) && Objects.equals(clientSeenPrice, cartItem.clientSeenPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, meal, quantity, clientSeenPrice);
    }
}


