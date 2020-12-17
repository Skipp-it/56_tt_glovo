package com.glovo.ttglovo.favourite_meal.controller;

import com.glovo.ttglovo.favourite_meal.model.Product;
import com.glovo.ttglovo.favourite_meal.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }


    @GetMapping(path = "/{name}/{id}")
    public void addNewFavoriteProduct(@PathVariable("name") String name, @PathVariable("id") int id) {
        Product product = new Product(name, id);
        favoritesService.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteFromFavorites(@PathVariable("id") int id){ favoritesService.removeProduct(id); }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id){ return favoritesService.getProductById(id);};

    @GetMapping()
    public List<Product> getFavouriteProducts(){
        return favoritesService.getAllProducts();
    }

}
