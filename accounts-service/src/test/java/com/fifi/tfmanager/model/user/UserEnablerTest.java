package com.fifi.tfmanager.model.user;

import com.fifi.tfmanager.dao.TokenRepository;
import com.fifi.tfmanager.dao.UserRepository;
import com.fifi.tfmanager.model.token.TokenReceiver;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserEnablerTest {

    private final String VALUE = "testValue";
    private final long ID = 12345L;

    @Mock
    UserRepository userRepository;
    @Mock
    TokenReceiver tokenReceiver;
    @InjectMocks
    UserEnabler userEnabler;

    @Test
    void should_enable_user() {
        User user = prepareUser();
        Mockito.when(tokenReceiver.getUserIdByToken(VALUE)).thenReturn(ID);
        Mockito.when(userRepository.findByUserId(ID)).thenReturn(user);

        userEnabler.enableByToken(VALUE);
        assertTrue(user.isEnabled());
    }

    private User prepareUser(){
        User user = new User();
        user.setUserId(ID);
        user.setEnabled(false);
        return user;
    }
}
