package com.glovo.ttglovo.cart;

import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.*;

import javax.persistence.*;

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


}


