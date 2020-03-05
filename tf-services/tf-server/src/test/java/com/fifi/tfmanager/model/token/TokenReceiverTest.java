package com.fifi.tfmanager.model.token;

import com.fifi.tfmanager.dao.TokenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TokenReceiverTest {

    private final String VALUE = "testValue";
    private final long ID = 12345L;

    @InjectMocks
    private TokenReceiver tokenReceiver;
    @Mock
    TokenRepository tokenRepository;

    @Test
    void should_return_id() {
        Mockito.when(tokenRepository.findByValue(VALUE)).thenReturn(prepareToken());
        long returnedId = tokenReceiver.getUserIdByToken(VALUE);
        assertEquals(ID, returnedId);

    }

    private VerificationToken prepareToken() {
        VerificationToken token = new VerificationToken(VALUE);
        token.setTokenId(ID);
        return token;
    }
}
