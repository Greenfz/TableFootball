package com.fifi.tfmanager.model.user;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.token.TokenReceiver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserEnabler {

    TokenReceiver tokenReceiver;
    UserRepository userRepository;

    @Transactional
    public void enableByToken(String tokenValue) {
        User user = getUserByToken(tokenValue);
        user.setEnabled(true);
        userRepository.save(user);

    }

    private User getUserByToken(String tokenValue) {
        long userId = tokenReceiver.getUserIdByToken(tokenValue);
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            user = new NullObjectUser();
        }
        return user;
    }

}
