package com.fifi.tfmanager.security.authentication.LoginStrategy;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("emailLoader")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmailLoader implements LoadUserStrategy {

    private UserRepository userRepository;

    @Override
    public User loadUser(String userData) {
        return userRepository.findByEmail(userData);
    }
}
