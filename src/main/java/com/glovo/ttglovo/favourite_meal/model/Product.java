package com.glovo.ttglovo.favourite_meal.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {

    private String name;
    private int id;

    public Product() {
        this.name = name;
        this.id = id;
    }


    public Product(String name, int id) {
        this.name = name;
        this.id = id;
    }


}
