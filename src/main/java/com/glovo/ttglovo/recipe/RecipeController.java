package com.glovo.ttglovo.recipe;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;


    @PostMapping()
    public void addNewRecipeItem(@RequestBody RecipeItem recipeItem){
        System.out.println(recipeItem);
        recipeService.saveRecipeItem(recipeItem);

    }

}
