package com.glovo.ttglovo.favourite_meal.service;

import com.glovo.ttglovo.favourite_meal.dao.FavoritesDAO;
import com.glovo.ttglovo.favourite_meal.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FavoritesService {

    private final FavoritesDAO favoritesDAO;

    public FavoritesService(@Qualifier("memory_repo") FavoritesDAO favoritesDAO) {
        this.favoritesDAO = favoritesDAO;
    }

    public void addNewProduct(Product product) throws SQLException {
        favoritesDAO.add(product);
    }

    public List<Product> getAllProducts() throws SQLException {
        return favoritesDAO.getAll();
    }

}
