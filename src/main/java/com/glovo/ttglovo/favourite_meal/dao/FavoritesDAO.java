package com.glovo.ttglovo.favourite_meal.dao;

import com.glovo.ttglovo.favourite_meal.model.Product;

import java.sql.SQLException;
import java.util.List;


public interface FavoritesDAO {

    void add(Product product) throws SQLException;

    void update(Product product) throws SQLException;

    String remove(int id) throws SQLException;

    Product get(int id) throws SQLException;

    List<Product> getAll() throws SQLException;
}

