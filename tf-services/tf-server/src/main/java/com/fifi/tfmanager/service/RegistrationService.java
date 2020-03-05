package com.fifi.tfmanager.service;

import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.exception.registrationExceptions.UserDuplicatedException;
import com.fifi.tfmanager.model.user.NewUserCreator;
import com.fifi.tfmanager.model.user.User;
import com.fifi.tfmanager.model.user.UserEnabler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationService {

    NewUserCreator newUserCreator;
    UserRepository userRepository;
    UserEnabler userEnabler;

    public void registerUser(User user) {
        if (doesUserExist(user)) {
            log.info("User found " + user.toString());
            throw new UserDuplicatedException();
        } else {
            newUserCreator.saveNewUser(user);
        }
    }

    public void enableByToken(String value) {
        userEnabler.enableByToken(value);
    }

    private boolean doesUserExist(User user) {
        return userRepository.findByUsername(user.getUsername()) != null || userRepository.findByEmail(user.getEmail()) != null;
    }
}
