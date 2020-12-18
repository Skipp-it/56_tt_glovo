package com.glovo.ttglovo.favourite_meal.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {

    private String name;
    private int id;
    private String thumbnail;
    private String price;
}
