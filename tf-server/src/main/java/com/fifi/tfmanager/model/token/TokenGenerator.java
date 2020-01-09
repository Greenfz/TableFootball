package com.fifi.tfmanager.model.token;

import com.fifi.tfmanager.model.user.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenGenerator {

    public VerificationToken generateToken() {
        return new VerificationToken(getRandomTokenValue());
    }

    private String getRandomTokenValue() {
        return UUID.randomUUID().toString();
    }
}
