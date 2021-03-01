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
        return  cartService.getAllCartItems(token);
    }

    @PostMapping("/add-meal")
    public ResponseEntity<Void> addNewCartProduct(@RequestBody @NotNull CartDto cartDto, @RequestHeader("Authorization") String token) {
        cartService.addCartItem(cartDto, token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-meal/{id}")
    public ResponseEntity<Void> deleteCartItem( @PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
        cartService.removeCartItem(id, token );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/increase/{id}")
    public ResponseEntity<Void> increaseCartItemQuantity(@PathVariable("id") Long id, @RequestHeader("Authorization") String token){
        System.out.println("increase , id" + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/decrease/{id}")
    public ResponseEntity<Void> decreaseCartItemQuantity(@PathVariable("id") Long id, @RequestHeader("Authorization") String token){
        System.out.println("decrease , id" + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable("id") int id){ return favoritesService.getProductById(id);};


}