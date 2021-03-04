package com.glovo.ttglovo.meal;


import com.glovo.ttglovo.favourite_meal.Favorite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Meal")
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @SequenceGenerator(
            name = "meal_sequence",
            sequenceName = "meal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meal_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "Integer",
            updatable = false
    )
    private Integer price;

    private String category;


    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "meal"
    )
    private Set<Favorite> favorites = new HashSet<>();


    public Meal(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }


    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void addUserFavoriteMeal(Favorite favorite) {
        favorites.add(favorite);
    }

    public void removeUserFavoriteMeal(Favorite favorite) {
        favorites.remove(favorite);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
