package com.glovo.ttglovo.user;

import com.glovo.ttglovo.cart.CartItem;
import com.glovo.ttglovo.favourite_meal.FavoriteMeal;
import com.glovo.ttglovo.prices.model.MealPrices;
import com.glovo.ttglovo.prices.repository.MealPricesRepository;
import com.glovo.ttglovo.registration.token.ConfirmationToken;
import com.glovo.ttglovo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG=" user with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final MealPricesRepository mealPricesRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }


     public String signUpUser(User user){
        boolean userExists= userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword= bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        String token= UUID.randomUUID().toString(); // am creat tokenul pe care il trimit la client

         ConfirmationToken confirmationToken=new ConfirmationToken(
                 token,
                 LocalDateTime.now(),
                 LocalDateTime.now().plusMinutes(15),
                 user
         );
         confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
     }

    public void saveCartItem(Long userId,Long mealId ){
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        MealPrices mealItem = mealPricesRepository.findById(mealId).orElseThrow(() -> new IllegalArgumentException("meal not found"));
        CartItem cartItem = new CartItem(
                mealItem.getId(),
                mealItem.getPrice(),
                user
        );
        user.addCartItem(cartItem);
    }

    public void removeCartItem(Long userId,Long mealId ){
//        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("user not found"));
//        MealPrices mealItem = mealPricesRepository.findById(mealId).orElseThrow(() -> new IllegalArgumentException("meal not found"));
    }

    public List<CartItem> getAllCartItems (Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        System.out.println("in user service 84");
        System.out.println(user.getCartItems());
        return user.getCartItems();
    }


    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}

