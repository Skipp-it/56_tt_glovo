package com.glovo.ttglovo.favourite_meal.controller;

import com.glovo.ttglovo.favourite_meal.model.Product;
import com.glovo.ttglovo.favourite_meal.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/fav")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }


    @PostMapping(path = "/{name}/{id}")
    public void addNewFavoriteProduct(@PathVariable("name") String name,  @PathVariable("id")int id) throws SQLException {
        System.out.println("addNewFavoriteProduct");
        Product product = new Product (name, id);
        favoritesService.addNewProduct(product);
        System.out.println("name " + name +" id " + id);
    }


    @GetMapping()
    public int getNumberOfFavProducts() throws SQLException {
        System.out.println("getNumberOfFavProducts");
        return favoritesService.getAllProducts().size();
    }

}
