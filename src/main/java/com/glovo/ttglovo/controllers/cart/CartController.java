package com.glovo.ttglovo.controllers.cart;

import com.glovo.ttglovo.cart.CartDto;
import com.glovo.ttglovo.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List<CartDto> getAllCartItems(@RequestHeader("Authorization") String token) {
        return cartService.getAllCartItems(token);
    }

    @PostMapping("/add-meal")
    public ResponseEntity<Void> addNewCartProduct(@RequestBody @NotNull CartDto cartDto, @RequestHeader("Authorization") String token) {
        cartService.addCartItem(cartDto, token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-meal/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
        cartService.removeCartItem(id, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update-cart")
    public ResponseEntity<Void> updateCartBeforePayment(@RequestBody @NotNull List<CartDto> cartItemDto, @RequestHeader("Authorization") String token) {
        System.out.println("----a intrat in update cart controller");
        cartService.updateCart(cartItemDto, token);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}