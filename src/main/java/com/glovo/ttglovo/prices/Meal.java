package com.glovo.ttglovo.prices;


import com.glovo.ttglovo.favourite_meal.UserFavMeal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Meal")
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor
public class Meal {

    @Id
    private Long id;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "Integer",
            updatable = false
    )
    private Integer price;


    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "meal"
    )
    private List<UserFavMeal> userFavMeals = new ArrayList<>();


    public Meal(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }


    public List<UserFavMeal> getUserFavMeals() {
        return userFavMeals;
    }

    public void addUserFavoriteMeal(UserFavMeal userFavMeal) {
        if (!userFavMeals.contains(userFavMeal)) {
            userFavMeals.add(userFavMeal);
        }
    }

    public void removeUserFavoriteMeal(UserFavMeal userFavMeal) {
        userFavMeals.remove(userFavMeal);
    }


    @Override
    public String toString() {
        return "MealPrices{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
