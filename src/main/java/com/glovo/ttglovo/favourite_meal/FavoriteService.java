package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.prices.MealRepository;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class FavoriteService {


    private final MealRepository mealRepository;
    private final AppUserRepository appUserRepository;
    private final JwtTokenServices jwtTokenServices;
    private final FavoriteRepository favoriteRepository;


    private AppUser getUserFromJwt(String token) {
        String email = (String) jwtTokenServices.parseUserFromTokenInfo(token.substring(7)).getPrincipal();
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", email)));

    }

    @Transactional
    public void addFavMeal(FavoriteDao favoriteDao, String token) {
        AppUser user = getUserFromJwt(token);
        Meal meal = mealRepository.findById(favoriteDao.getMealId()).orElseThrow(() ->
                new FavoriteMealNotFoundException(String.format("meal with id=%s not found", favoriteDao.getMealId())));

        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(user.getId());
        favoriteId.setMealId(meal.getId());

        Favorite favorite = new Favorite();
        favorite.setMeal(meal);
        favorite.setUser(user);
        favorite.setId(favoriteId);
        favoriteRepository.save(favorite);

    }
}
