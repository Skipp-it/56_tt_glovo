//package com.glovo.ttglovo.cart;
//
//
//import com.glovo.ttglovo.securityManagement.appuser.AppUserService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@RestController
//@RequestMapping("/cart")
//@CrossOrigin(origins = "http://localhost:3000")
//@AllArgsConstructor
//public class CartController {
//
//private final AppUserService userService;
//
//    @GetMapping("/{user-id}")
//    public List<CartItem> getAllCartItems(@PathVariable("user-id") Long userId) {
//        return userService.getAllCartItems(userId);
//    }
//
//    @PostMapping()
//    public void addNewCartProduct(@RequestBody @NotNull @PathVariable("user_id") Long userId,@PathVariable("meal_id") Long mealId) {
//        System.out.println("--------------------intra");
//        userService.saveCartItem(userId, mealId );
//    }
//
//    @DeleteMapping("/{user_id}/{meal_id}")
//    public void deleteCartItem( @PathVariable("user_id") Long userId, @PathVariable("meal_id") Long mealId) {
//        userService.removeCartItem(userId, mealId );
//    }
//
//    //
////    @GetMapping("/{id}")
////    public Product getProductById(@PathVariable("id") int id){ return favoritesService.getProductById(id);};
//
//
//}