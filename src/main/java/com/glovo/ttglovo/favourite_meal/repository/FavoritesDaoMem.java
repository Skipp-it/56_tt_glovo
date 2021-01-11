package com.glovo.ttglovo.favourite_meal.repository;

import com.glovo.ttglovo.favourite_meal.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("memory_repo")
public class FavoritesDaoMem implements FavoritesDAO {

    private static final List<Product> favoritesList = new ArrayList<>();

    @Override
    public void add(Product product) { favoritesList.add(product); }

    @Override
    public void remove(int id) { favoritesList.removeIf(product -> product.getId() == id); }

    @Override
    public Product get(int id) {
        return favoritesList.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return favoritesList;
    }


}

