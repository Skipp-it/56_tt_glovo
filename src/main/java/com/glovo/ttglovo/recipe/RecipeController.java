package com.glovo.ttglovo.recipe;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;


    @PostMapping("/addRecipe")
    public ResponseEntity<Void> addNewRecipeItem(@RequestBody RecipeItem recipeItem, @RequestHeader("Authorization") String token){
        recipeService.saveRecipeItem(recipeItem,token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<RecipeItem> getAllRecipes( ){
     return recipeService.getAllRecipes();
    }

}
