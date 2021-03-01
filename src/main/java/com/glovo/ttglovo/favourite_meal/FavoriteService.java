package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.Meal.Meal;
import com.glovo.ttglovo.Meal.MealDto;
import com.glovo.ttglovo.Meal.MealMapper;
import com.glovo.ttglovo.Meal.MealRepository;
import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


@Service
@AllArgsConstructor
@Slf4j
public class FavoriteService {


    private final MealRepository mealRepository;
    private final AppUserRepository appUserRepository;
    private final FavoriteRepository favoriteRepository;
    private final MealMapper mealMapper;


    private AppUser getAppUser(String principal) {
        return appUserRepository.findByEmail(principal).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", principal)));
    }
    @Transactional
    public void addFavMeal(FavoriteDto favoriteDto, String principal) {
        AppUser user = getAppUser(principal);
        Meal meal = mealRepository.findById(favoriteDto.getMealId()).orElseThrow(() ->
                new FavoriteMealNotFoundException(String.format("meal with id=%s not found", favoriteDto.getMealId())));

        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(user.getId());
        favoriteId.setMealId(meal.getId());

        Favorite favorite = new Favorite();
        favorite.setMeal(meal);
        favorite.setUser(user);
        favorite.setId(favoriteId);
        favorite.setCreatedAt(LocalDateTime.now());
        favoriteRepository.save(favorite);


//        user.addUserFavoriteMeal(favorite);
//
//        appUserRepository.save(user);

    }


    @Transactional(readOnly = true)
    public Set<MealDto> getAllMeals(String principal){
        AppUser user = getAppUser(principal);
        return user.getFavorites()
                .stream()
                .map(mealMapper::mealToMealDto)
                .collect(toSet());
    }


    @Transactional
    public boolean delete(Long id, String principal) {
        AppUser user = getAppUser(principal);
        Favorite favorite = user.getFavorites().stream().filter(fav -> fav.getMeal().getId().equals(id)).findFirst()
                .orElseThrow(()->new FavoriteMealNotFoundException(String.format("favorite with id=%s not found", id)));
        user.removeFavoriteMeal(favorite);
        return true;
    }
}
