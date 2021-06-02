package com.glovo.ttglovo.controllers.appUser;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/client")
@AllArgsConstructor
public class AppUserInfoController {

    private final AppUserService appUserService;

    @GetMapping()
    public String currentUser() {
        //TODO atentie user e email!!!

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) appUserService.loadUserByUsername((String) authentication.getPrincipal());

        String response = user.getUsername() + "\n" + user.getAppUserRole();
        return response;
    }
}


