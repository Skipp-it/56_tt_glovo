package com.glovo.ttglovo.controllers.recipe;

import com.glovo.ttglovo.recipe.RecipeDTO;
import com.glovo.ttglovo.recipe.RecipeItem;
import com.glovo.ttglovo.recipe.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*", maxAge = 3600)

public class RecipeController {

    private final RecipeService recipeService;

    //folder unde se salveaza pozele
    String UPLOAD_FOLDER = "W:\\CODECOOL\\ADVANCE\\56_tt_glovo\\src\\main\\static\\uploadImage\\";


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/addRecipe")
    public ResponseEntity<?> addNewRecipeItem(@RequestBody RecipeItem recipeItem, @RequestHeader("Authorization") String token) throws IllegalStateException, IOException {
//        file.transferTo(new File(UPLOAD_FOLDER+file.getOriginalFilename()));

        recipeService.saveRecipeItem(recipeItem, token);
        return ResponseEntity.accepted().body("recipe added");
    }

    @GetMapping("/all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteRecipe(@PathVariable Long id) {
        var isRemoved = recipeService.deleteRecipeById(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
