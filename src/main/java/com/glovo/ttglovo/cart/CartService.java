package com.glovo.ttglovo.cart;

import com.glovo.ttglovo.exceptions.CartItemNotFoundException;
import com.glovo.ttglovo.prices.Meal;
import com.glovo.ttglovo.prices.MealRepository;
import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import com.glovo.ttglovo.securityManagement.security.jwt.JwtTokenServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {

    private final MealRepository mealRepository;
    private final JwtTokenServices jwtTokenServices;
    private final AppUserRepository appUserRepository;
    private final CartRepository cartRepository;

    private AppUser getUserFromJwt(String token) {
        String email = (String) jwtTokenServices.parseUserFromTokenInfo(token.substring(7)).getPrincipal();
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", email)));
    }

    @Transactional
    public void addCartItem(CartDto cartDto, String token) {

        AppUser user = getUserFromJwt(token);
        Meal meal = mealRepository.findById(cartDto.getMealId()).orElseThrow(() ->
                new CartItemNotFoundException(String.format("cart with id %s not found", cartDto.getMealId())));
        CartId cartId = new CartId();
        cartId.setMealId(meal.getId());
        cartId.setUserId(user.getId());

        CartItem cartItem = new CartItem(
                cartId,
                user,
                meal,
                cartDto.getQuantity(),
                cartDto.getPrice()
        );
        cartRepository.save(cartItem);
    }

    public List<CartDto> getAllCartItems(String token) {
        Long userId = getUserFromJwt(token).getId();
        System.out.println("-------in cart service 50");
        System.out.println( cartRepository.findAllCartItemsByUserId(userId).toString());
        return transformToDto(cartRepository.findAllCartItemsByUserId(userId));
    }

    private List<CartDto> transformToDto(List<CartItem> cartItems){
        return cartItems.
                stream()
                .map(item -> new CartDto(item.getId().getMealId(), item.getQuantity(), item.getClientSeenPrice()))
                .collect(Collectors.toList());
    }
}
