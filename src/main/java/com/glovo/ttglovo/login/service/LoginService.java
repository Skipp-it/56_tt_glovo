package com.glovo.ttglovo.login.service;

import com.glovo.ttglovo.user.User;
import com.glovo.ttglovo.user.UserRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@NoArgsConstructor
public class LoginService {

    UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUsernameByEmailAndPassword(User user) {
        try{
            return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        } catch (Exception e){ }
        return null;
    }
}