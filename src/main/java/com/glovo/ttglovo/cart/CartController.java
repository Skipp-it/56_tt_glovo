package com.glovo.ttglovo.cart;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;


    @GetMapping()
    public  List<CartDto> getAllCartItems(@RequestHeader("Authorization") String token) {
        System.out.println("-----------------------------intra in get all cart items");
        System.out.println("-----------23 " + cartService.getAllCartItems(token));
        return  cartService.getAllCartItems(token);
    }

    @PostMapping("/add-meal")
    public ResponseEntity<Void> addNewCartProduct(@RequestBody @NotNull CartDto cartDto, @RequestHeader("Authorization") String token) {
        cartService.addCartItem(cartDto, token);
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