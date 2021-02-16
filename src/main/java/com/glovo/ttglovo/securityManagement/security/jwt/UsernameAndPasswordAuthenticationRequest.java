package com.glovo.ttglovo.securityManagement.security.jwt;

import com.glovo.ttglovo.securityManagement.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {

    private String email;
    private String password;
    private AppUserRole appUserRole;
}
