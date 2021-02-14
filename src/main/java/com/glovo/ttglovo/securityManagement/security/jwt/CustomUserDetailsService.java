package com.glovo.ttglovo.securityManagement.security.jwt;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import com.glovo.ttglovo.securityManagement.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository users;

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object.
     * Spring will call this code to retrieve a user upon login from the DB.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //this time the username is the email!!!
        AppUser user = users.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Email " + email+" not found"));

        return (UserDetails) new UsernameAndPasswordAuthenticationRequest(
                                        user.getEmail(),
                                        user.getPassword(),
                                        user.getAppUserRole());
    }
}
