package com.fifi.tfmanager.dao;

import com.fifi.tfmanager.model.user.User;
import com.fifi.tfmanager.model.token.VerificationToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;

    @Test
    void testSave(){
        User user = new User();
        user.setUsername("fifi");
        user.setPassword("XXXXxxXXX");
        user.setEmail("eee@e.e");
//        userRepository.save(user);

        VerificationToken token = new VerificationToken("xxxxxxxxxxxx");
        token.setUser(user);
        tokenRepository.save(token);
    }
}
