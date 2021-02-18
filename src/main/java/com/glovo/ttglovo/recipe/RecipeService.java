package com.glovo.ttglovo.recipe;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final AppUserRepository appUserRepository;


    public void saveRecipeItem(RecipeItem recipeItem){
        AppUser user=appUserRepository.findById(recipeItem.getId()).orElseThrow();
        recipeRepository.save(recipeItem);
    }
}
