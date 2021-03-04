package com.glovo.ttglovo.recipe;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
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
    public void saveRecipeItem(RecipeItem recipeItem, String token) throws IOException {
       AppUser user = getUserFromJwt(token);

       RecipeItem recipe= new RecipeItem();
       recipe.setName(recipeItem.getName());
       recipe.setDescription(recipeItem.getDescription());
       recipe.setImage(recipeItem.getImage());
       recipe.setUser(user);



       recipeRepository.save(recipe);

   }

   public List<RecipeDTO> getAllRecipes(){
        List<RecipeDTO> recipeDTOList=new ArrayList<>();
       List<RecipeItem> list=recipeRepository.findAll();

       for (RecipeItem recipeItem : list) {
       RecipeDTO recipeDTO=new RecipeDTO();
       recipeDTO.setId(recipeItem.getId());
       recipeDTO.setDescription(recipeItem.getDescription());
       recipeDTO.setName(recipeItem.getName());
       recipeDTO.setUserFirstName(recipeItem.getUser().getFirstName());
       recipeDTO.setUserId(recipeItem.getUser().getId());
       recipeDTO.setImage(recipeItem.getImage());
       recipeDTOList.add(recipeDTO);
       }
       return  recipeDTOList;
   }

    public boolean deleteRecipeById(Long id) {
       recipeRepository.deleteById(id);
        return true;
    }
}
