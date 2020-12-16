package com.glovo.ttglovo.favourite_meal.controller;

import com.glovo.ttglovo.favourite_meal.model.Product;
import com.glovo.ttglovo.favourite_meal.service.FavoritesService;
import org.springframework.web.bind.annotation.*;import java.util.stream.Collectors;


@RestController
@RequestMapping("/fav")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }


    @GetMapping(path = "/{name}/{id}")
    public void addNewFavoriteProduct(@PathVariable("name") String name,  @PathVariable("id")int id) {
        System.out.println("addNewFavoriteProduct");
        Product product = new Product (name, id);
        favoritesService.addNewProduct(product);
        System.out.println("name " + name +" id " + id);
    }


    @GetMapping("/list")
    public int getNumberOfFavProducts() {
        System.out.println("getNumberOfFavProducts");
        System.out.println(favoritesService.getAllProducts().size());
        return favoritesService.getAllProducts().size();
    }

    @GetMapping("/names")
    public String getNames(){
        return favoritesService.getAllProducts().stream().map(p -> p.getName()).collect(Collectors.toList()).toString();
    }

}
