package com.glovo.ttglovo.user;

import com.glovo.ttglovo.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional()
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

}


//    public void save(FavoritesDto favoritesDto) {
//        User favUser = userRepository.findById(favoritesDto.getUserId()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
//        MealPrices mealPrices = mealPricesRepository.findById(favoritesDto.getMealId()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
//
//        favUser.addMealToFavorites(mealPrices);
//
//        userRepository.save(favUser);
//    }