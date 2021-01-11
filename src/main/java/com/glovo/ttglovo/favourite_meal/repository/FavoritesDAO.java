
package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.favourite_meal.model.Product;

import java.util.List;


public interface FavoritesDAO {

    void add(Product product);

    void remove(int id);

    Product get(int id);

    List<Product> getAll();
}
