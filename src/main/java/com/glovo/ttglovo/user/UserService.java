package com.glovo.ttglovo.user;



import com.glovo.ttglovo.registration.token.ConfirmationToken;
import com.glovo.ttglovo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG=" user with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        System.out.println("USER_SERVICE "+username);
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }


     public String signUpUser(User user){
        boolean userExists= userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword= bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        String token= UUID.randomUUID().toString(); // am creat tokenul pe care il trimit la client

         ConfirmationToken confirmationToken=new ConfirmationToken(
                 token,
                 LocalDateTime.now(),
                 LocalDateTime.now().plusMinutes(15),
                 user
         );
         confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
     }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}
