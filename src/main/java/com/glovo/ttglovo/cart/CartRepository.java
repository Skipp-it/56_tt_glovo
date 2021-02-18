package com.glovo.ttglovo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    @Query(value="SELECT * FROM cart_items WHERE user_id = ?1", nativeQuery = true)
    List<CartItem> findAllCartItemsByUserId(Long userId);

//    Optional<CartItem> findCartItemsByUser(Long userId);
}
