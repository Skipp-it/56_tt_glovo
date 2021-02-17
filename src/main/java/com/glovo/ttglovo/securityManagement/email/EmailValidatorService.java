package com.glovo.ttglovo.securityManagement.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidatorService implements Predicate<String> {
    @Override
    public boolean test(String email) {
        //TODO: Regex to check email
        return true;
    }
}
