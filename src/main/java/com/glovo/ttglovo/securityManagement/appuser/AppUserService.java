package com.glovo.ttglovo.securityManagement.appuser;

import com.glovo.ttglovo.bruteForce.LoginAttemptService;
import com.glovo.ttglovo.securityManagement.registration.token.ConfirmationToken;
import com.glovo.ttglovo.securityManagement.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AppUserService implements UserDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final LoginAttemptService loginAttemptService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));;
        if (user == null) {
            LOGGER.error("No user found by username :" + email);
            throw new UsernameNotFoundException("No user found by username :" + email);
        } else {
            validateLoginAttempt(user);
            appUserRepository.save(user);
            LOGGER.info("Returning found user by username :" + email);
            return user;
        }

    }

    private void validateLoginAttempt(AppUser user) {
        if (user.isAccountNonLocked()) {
            if (loginAttemptService.hasExceededMaxAttempts(user.getUsername())) {
                user.setIsNonLocked(false);
            } else {
                user.setIsNonLocked(true);
            }
        } else {
            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
        }
    }



    @Transactional
    public String signUpUser(AppUser appUser) {

        /**
         * 1. step
         * check if user already exists
         * */
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
        //TODO check of attributes are the same and
        // TODO if email not confirmed send confirmation email
            // if email not confirmed send confirmation email
            throw new IllegalStateException("email already exists");
        }


        /**
         * 2. step
         * for new user , encrypt password
         * */

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
//        appUser.setLocked(false);

        /**
         * 3. step
         * save user in DB
         * */
        appUserRepository.save(appUser);

        /**
         * 4. step
         * create token
         * */
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        /**
         * 5. step
         * save, in DB, AND return auth token
         * */
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
