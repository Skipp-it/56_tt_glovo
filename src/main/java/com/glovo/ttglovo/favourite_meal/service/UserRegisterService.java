package com.glovo.ttglovo.favourite_meal.service;

import com.glovo.ttglovo.favourite_meal.model.User;
import com.glovo.ttglovo.favourite_meal.repository.UserRegistrationRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Getter
@Setter
@NoArgsConstructor
public class UserRegisterService {

    UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegisterService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    public boolean addNewUser(User user) {
        if ((user.getId()==null) && (getUserByEmail(user.getEmail()).isEmpty())) {
            user.setId(UUID.randomUUID());
            userRegistrationRepository.save(user);
            return true;
        }
        return false;
    }

    public Optional<User> getUserById(UUID id) {
        return userRegistrationRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRegistrationRepository.findByEmail(email);
    }


    //TODO de sters !!!!
    public List<User> getAllUsers() {
        return (List<User>) userRegistrationRepository.findAll();
    }
}
