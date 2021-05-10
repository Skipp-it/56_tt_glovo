package com.glovo.ttglovo.securityManagement.email;

import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class EmailValidatorService implements Predicate<String> {

    private final AppUserRepository appUserRepository;

    @Override
    public boolean test(String email) {
        return appUserRepository.findByEmail(email).stream().findAny().isEmpty();
    }
}
