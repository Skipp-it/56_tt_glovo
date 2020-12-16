package com.glovo.ttglovo.favourite_meal.controller;

import com.glovo.ttglovo.favourite_meal.model.Product;
import com.glovo.ttglovo.favourite_meal.service.FavoritesService;
import org.springframework.web.bind.annotation.*;import java.util.stream.Collectors;
import java.util.List;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }


    @GetMapping(path = "/{name}/{id}")
    public void addNewFavoriteProduct(@PathVariable("name") String name,  @PathVariable("id")int id) {
        Product product = new Product (name, id);
        favoritesService.addNewProduct(product);
    }


    @GetMapping()
    public List<Product> getFavouriteProducts(){
        return favoritesService.getAllProducts();
    }

}
