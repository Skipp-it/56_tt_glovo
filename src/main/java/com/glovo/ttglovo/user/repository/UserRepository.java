package com.glovo.ttglovo.user.repository;

import com.glovo.ttglovo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2")
    Optional<User> findByEmailAndPassword(String email, String password);
}
