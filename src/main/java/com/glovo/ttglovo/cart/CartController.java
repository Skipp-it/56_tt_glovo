package com.glovo.ttglovo.cart;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

//    @GetMapping("/{user-id}")
//    public List<CartItem> getAllCartItems(@PathVariable("user-id") Long userId) {
//        return userService.getAllCartItems(userId);
//    }

    @PostMapping("/add-meal")
    public ResponseEntity<Void> addNewCartProduct(@RequestBody @NotNull CartDao cartDao, @RequestHeader("Authorization") String token) {
        System.out.println("--------------------intra in 26 cart controller");
        cartService.addCartItem(cartDao, token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @DeleteMapping("/{user_id}/{meal_id}")
//    public void deleteCartItem( @PathVariable("user_id") Long userId, @PathVariable("meal_id") Long mealId) {
//        userService.removeCartItem(userId, mealId );
//    }

    //
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable("id") int id){ return favoritesService.getProductById(id);};


}