package com.fifi.tfmanager.security.authentication;

import com.fifi.tfmanager.model.user.User;
import com.fifi.tfmanager.security.authentication.LoginStrategy.EmailLoader;
import com.fifi.tfmanager.security.authentication.LoginStrategy.LoadUserStrategy;
import com.fifi.tfmanager.security.authentication.LoginStrategy.NameLoader;
import com.fifi.tfmanager.security.authority.CustomUserDetails;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AuthenticationHandler implements UserDetailsService {

    @Autowired
    private LoadUserStrategy nameLoadStrategy;
    @Autowired
    @Qualifier("emailLoader")
    private LoadUserStrategy emailLoadStrategy;

    @Override
    public UserDetails loadUserByUsername(String userData) throws UsernameNotFoundException {
        User user = nameLoadStrategy.loadUser(userData);
        if (user == null) {
            emailLoadStrategy.loadUser(userData);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User with this name not detected");

        }
        return new CustomUserDetails(user);
    }

}
