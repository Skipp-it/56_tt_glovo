package com.glovo.ttglovo.recipe;

import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
import com.glovo.ttglovo.favourite_meal.FavoriteDao;
import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final AppUserRepository appUserRepository;
    private final JwtTokenServices jwtTokenServices;

    private AppUser getUserFromJwt(String token) {
        String email = (String) jwtTokenServices.parseUserFromTokenInfo(token.substring(7)).getPrincipal(); //se extrage emailul din token
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", email)));

    }

   @Transactional
    public void saveRecipeItem(RecipeItem recipeItem,String token){
       AppUser user = getUserFromJwt(token);

       RecipeItem recipe= new RecipeItem();
       recipe.setName(recipeItem.getName());
       recipe.setDescription(recipeItem.getDescription());
       recipe.setUser(user);
       recipeRepository.save(recipe);

   }

   public List<RecipeItem> getAllRecipes(){
       List<RecipeItem> list=recipeRepository.findAll();
       return  list;
   }
}
