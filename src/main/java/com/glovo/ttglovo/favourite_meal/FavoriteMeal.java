package com.glovo.ttglovo.favourite_meal;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="FavoriteMeal")
@Table(name="favorites_meal")
public class FavoriteMeal {

    @Id
    @Column(name="id_meal")
    private Long id;

    @Column(name="price")
    private int price;

    @Column(name = "user_id")
    private UUID user_id;



    public FavoriteMeal( Long id, int price) {
        this.id = id;
        this.price=price;
    }
    public FavoriteMeal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FavoriteMeal{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}