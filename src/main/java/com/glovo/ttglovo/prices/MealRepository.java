package com.glovo.ttglovo.prices;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findById(Long id);

    List<Meal> findAll();


//    Set<Meal> findAllByUser(AppUser user);
}
