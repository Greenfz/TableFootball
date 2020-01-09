package com.fifi.tfmanager.security.authentication;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.user.User;
import com.fifi.tfmanager.security.authentication.LoginStrategy.EmailLoader;
import com.fifi.tfmanager.security.authentication.LoginStrategy.LoadUserStrategy;
import com.fifi.tfmanager.security.authentication.LoginStrategy.NameLoader;
import com.fifi.tfmanager.security.authority.CustomUserDetails;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Setter
@Service
public class AuthenticationHandler implements UserDetailsService {

    private LoadUserStrategy loadUserStrategy;

    @Override
    public UserDetails loadUserByUsername(String userData) throws UsernameNotFoundException {
        setLoadUserStrategy(new NameLoader());
        User user = loadUserStrategy.loadUser(userData);
        if (user == null) {
            setLoadUserStrategy(new EmailLoader());
        }
        if (user == null) {
            throw new UsernameNotFoundException("User with this name not detected");

        }
        return new CustomUserDetails(user);
    }
}
