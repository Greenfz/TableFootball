package com.fifi.tfmanager.security.authentication.LoginStrategy;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class EmailLoader implements LoadUserStrategy {


    private UserRepository userRepository;

    @Override
    public User loadUser(String userData) {
        return userRepository.findByEmail(userData);
    }
}
