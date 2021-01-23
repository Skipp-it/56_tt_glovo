//package com.glovo.ttglovo.favourite_meal.repository;
//
//import com.glovo.ttglovo.favourite_meal.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public interface UserRegistrationRepository extends JpaRepository<User, UUID> {
//
//    @Query("SELECT u FROM User u WHERE u.email=?1")
//    Optional<User> findByEmail(String email);
//}
