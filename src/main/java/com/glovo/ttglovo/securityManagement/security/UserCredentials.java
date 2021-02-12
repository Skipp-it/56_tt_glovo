package com.glovo.ttglovo.securityManagement.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {
    //TODO username is not on db!!!
    private String username;
    private String password;

}
