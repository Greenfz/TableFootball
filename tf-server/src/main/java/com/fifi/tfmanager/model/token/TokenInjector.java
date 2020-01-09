package com.fifi.tfmanager.model.token;

import com.fifi.tfmanager.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenInjector {

    private TokenGenerator tokenGenerator;

    public VerificationToken injectToken(User user) {
        VerificationToken token = tokenGenerator.generateToken();
        token.setUser(user);
        user.setVerificationToken(token);
        return token;
    }

    @Autowired
    public TokenInjector(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }
}
