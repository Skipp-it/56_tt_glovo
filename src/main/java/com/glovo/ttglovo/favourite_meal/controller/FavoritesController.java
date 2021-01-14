package com.glovo.ttglovo.favourite_meal.controller;

import com.glovo.ttglovo.favourite_meal.model.FavoriteMeal;
import com.glovo.ttglovo.favourite_meal.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/favorites")
@CrossOrigin(origins = "http://localhost:3000")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping()
    public void addNewFavoriteProduct(@RequestBody @NotNull FavoriteMeal favoriteMeal) {
        favoritesService.saveFavorites(favoriteMeal);
    }

    @DeleteMapping("/{id}")
    public void deleteFromFavorites(@PathVariable("id") Long id) {
        favoritesService.removeProduct(id);
    }

    //
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable("id") int id){ return favoritesService.getProductById(id);};
//
    @GetMapping()
    public List<FavoriteMeal> getAllFavoritesMeal() {
        return favoritesService.getAllFavoritesMeal();
    }

}