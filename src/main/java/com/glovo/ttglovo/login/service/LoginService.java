package com.glovo.ttglovo.login.service;

import com.glovo.ttglovo.user.model.User;
import com.glovo.ttglovo.user.repository.UserRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@NoArgsConstructor
public class LoginService {


    UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUsernameByEmailAndPassword(User user) {
        System.out.println("aici");
        System.out.println(getUserByEmail(user.getEmail()));
        var loggedUser = getUserByEmailAndPassword(user.getEmail(), user.getPassword());


            return loggedUser;
        }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
