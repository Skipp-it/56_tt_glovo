package com.glovo.ttglovo.bruteForce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

//se trigger cand user-ul greseste parola
@Component
public class AuthenticationFailureListener {
    private LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationFailureListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void OnAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event){
        Object principal = event.getAuthentication().getPrincipal();
        if(principal instanceof String){
            String username = (String) event.getAuthentication().getPrincipal();
        loginAttemptService.addUserToLoginAttemptCache(username);
        }
    }
}
