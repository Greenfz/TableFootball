package com.fifi.tfmanager.security.authentication.LoginStrategy;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component("nameLoader")
@Primary
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class NameLoader implements LoadUserStrategy {

    private UserRepository userRepository;

    @Override
    public User loadUser(String name) {
        return userRepository.findByUsername(name);
    }
}

