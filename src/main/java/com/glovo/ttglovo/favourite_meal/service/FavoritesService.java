package com.glovo.ttglovo.favourite_meal.service;

import com.glovo.ttglovo.favourite_meal.repository.FavoritesDAO;
import com.glovo.ttglovo.favourite_meal.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {

    private final FavoritesDAO favoritesDAO;

    public FavoritesService(@Qualifier("memory_repo") FavoritesDAO favoritesDAO) {
        this.favoritesDAO = favoritesDAO;
    }

    public void addNewProduct(Product product) {
        favoritesDAO.add(product);
    }

    public void removeProduct(int id){ favoritesDAO.remove(id); }

    public Product getProductById (int id){return favoritesDAO.get(id);};

    public List<Product> getAllProducts() { return favoritesDAO.getAll();}

}