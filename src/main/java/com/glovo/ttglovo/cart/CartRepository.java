package com.glovo.ttglovo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    @Query(value="SELECT * FROM cart_items WHERE user_id = ?1", nativeQuery = true)
    List<CartItem> findAllCartItemsByUserId(Long userId);

    @Modifying
    @Transactional
    Optional<CartItem> deleteCartItemById(CartId cartId);

//    @Modifying
//    @Transactional
//    Optional<CartItem> findCartItemsBy

//    Optional<CartItem> findCartItemsByUser(Long userId);
}

//
//    @Modifying
//    @Transactional
//    void removeTodoById(Long id);