package com.glovo.ttglovo.favourite_meal;


import com.glovo.ttglovo.favourite_meal.FavoriteMeal;
import com.glovo.ttglovo.favourite_meal.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritesService {


    private final FavoritesRepository favoritesRepository;
    private List favoriteMealList=new ArrayList();

    @Autowired
    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }


    public void saveFavorites(FavoriteMeal favoriteMeal) {
        if(!favoritesRepository.existsById(favoriteMeal.getId()))
        {favoritesRepository.save(favoriteMeal);}
        else System.out.println("This meal is added in favorites");
    }
    public List<FavoriteMeal> getAllFavoritesMeal(){
        return favoritesRepository.findAll();

    }

    public void removeProduct(Long id) {
        favoritesRepository.deleteById(id);
    }
}