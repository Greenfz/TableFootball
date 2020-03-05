package com.fifi.tfmanager.model.user;

import com.fifi.tfmanager.dao.TokenRepository;
import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.token.TokenInjector;
import com.fifi.tfmanager.model.token.VerificationToken;
import com.fifi.tfmanager.service.EncryptionHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NewUserCreator {

    EncryptionHandler encryptionHandler;
    TokenInjector tokenInjector;
    UserRepository userRepository;
    TokenRepository tokenRepository;

    @Transactional
    public void saveNewUser(User user) {
        encryptionHandler.encodePassword(user);
        VerificationToken token = tokenInjector.injectToken(user);
        userRepository.save(user);
        tokenRepository.save(token);
    }
}
