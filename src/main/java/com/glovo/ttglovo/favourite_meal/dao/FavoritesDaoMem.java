package com.glovo.ttglovo.favourite_meal.dao;

import com.glovo.ttglovo.favourite_meal.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("memory_repo")
public class FavoritesDaoMem implements FavoritesDAO{

    private static List<Product> favoritesList = new ArrayList<>();


    @Override
    public void add(Product product) throws SQLException {
        product.setId(favoritesList.size() + 1);
        favoritesList.add(product);
    }

    @Override
    public String remove(int id) throws SQLException {
        favoritesList.stream().filter(p -> p.getId() != id);
        return "product removed";
    }

    @Override
    public void update(Product product) throws SQLException {
//        favoritesList.get(product.getId());
    }


    @Override
    public Product get(int id) throws SQLException {
        return favoritesList.stream().filter(t -> t.getId() ==  id).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        return favoritesList;
    }
}
