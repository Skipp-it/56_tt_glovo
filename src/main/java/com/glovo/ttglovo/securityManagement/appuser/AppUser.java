package com.glovo.ttglovo.securityManagement.appuser;

import com.glovo.ttglovo.cart.CartItem;
import com.glovo.ttglovo.favourite_meal.UserFavMeal;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AppUser")
@Table(name = "user_table",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "email",
                        name = "uk_email"
                )
        }
)
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "First name may not be empty")
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @NotEmpty(message = "Last name may not be empty")
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Email(regexp = ".+@.+\\..+")
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @NotEmpty(message = "Password may not be empty")
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "appUser"
    )
    private List<UserFavMeal> userFavMeals = new ArrayList<>();

    @Column(
            name = "app_user_role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private Boolean locked = false;

    private Boolean enabled = false;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<CartItem> cartItems = new ArrayList<>();

    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(email, appUser.email) && Objects.equals(password, appUser.password) && appUserRole == appUser.appUserRole && Objects.equals(locked, appUser.locked) && Objects.equals(enabled, appUser.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, appUserRole, locked, enabled);
    }


    public List<UserFavMeal> getUserFavMeals() {
        return userFavMeals;
    }

    public void addUserFavoriteMeal(UserFavMeal userFavMeal) {
        if (!userFavMeals.contains(userFavMeal)) {
            userFavMeals.add(userFavMeal);
        }
    }

    public void removeUserFavoriteMeal(UserFavMeal userFavMeal) {
        userFavMeals.remove(userFavMeal);
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", username='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", appUserRole=" + appUserRole +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}
