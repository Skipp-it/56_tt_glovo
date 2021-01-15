package com.glovo.ttglovo.user.service;

import com.glovo.ttglovo.user.repository.UserRepository;
import com.glovo.ttglovo.user.model.User;
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
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addNewUser(User user) {
        if ((user.getId()==null) && (getUserByEmail(user.getEmail()).isEmpty())) {
            user.setId(UUID.randomUUID());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    //TODO de sters !!!!
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
