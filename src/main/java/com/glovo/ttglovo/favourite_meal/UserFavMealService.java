package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.exceptions.FavoriteMealNotFoundException;
import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.prices.MealRepository;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserFavMealService {


    private final MealRepository mealRepository;
    private final AppUserRepository appUserRepository;

    public void addFavMeal(UserFavDao userFavDao) {
        AppUser appUser = appUserRepository.findById(userFavDao.getAppUserId()).orElseThrow(() ->
                new UsernameNotFoundException(String.format("user with id= %s not found", userFavDao.getAppUserId())));
        Meal meal = mealRepository.findById(userFavDao.getMealId()).orElseThrow(() ->
                new FavoriteMealNotFoundException(String.format("meal with id=%s not found", userFavDao.getMealId())));

        UserFavMealId userFavMealId = new UserFavMealId();
        userFavMealId.setAppUserId(appUser.getId());
        userFavMealId.setMealId(meal.getId());

        UserFavMeal userFavMeal = new UserFavMeal();
        userFavMeal.setMeal(meal);
        userFavMeal.setId(userFavMealId);

//        meal.addUserFavoriteMeal(userFavMeal);
//        mealRepository.save(meal);

        appUser.addUserFavoriteMeal(userFavMeal);
        appUserRepository.save(appUser);

    }
}
