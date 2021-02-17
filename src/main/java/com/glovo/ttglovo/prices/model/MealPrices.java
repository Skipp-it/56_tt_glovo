package com.glovo.ttglovo.prices.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "MealPrices")
@Table(name = "meal_prices")
@Getter
@Setter
@NoArgsConstructor
public class MealPrices {

    @Id
    private Long id;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer price;


    public MealPrices(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MealPrices{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
