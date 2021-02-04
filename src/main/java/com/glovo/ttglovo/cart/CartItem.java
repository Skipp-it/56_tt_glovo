package com.glovo.ttglovo.cart;

import com.glovo.ttglovo.user.User;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "CartItem")
@Table(name = "cart_items")
public class CartItem {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "meal_id")
    private Long mealId;

    @Column(
            name = "meal_price",
            nullable = false,
            columnDefinition = "Integer")
    private Integer mealPrice;

    public CartItem(Long mealId, Integer mealPrice, User user) {
        this.mealId = mealId;
        this.mealPrice = mealPrice;
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    private User user;


}


