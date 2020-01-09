package com.fifi.tfmanager.model.token;

import com.fifi.tfmanager.dao.TokenRepository;
import com.fifi.tfmanager.exception.registrationExceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TokenReceiver {

    TokenRepository tokenRepository;

    public long getUserIdByToken(String tokenValue){
        System.out.println();
        VerificationToken token = tokenRepository.findByValue(tokenValue);
        if(token == null){
            throw new UserNotFoundException();
        }
        else
        return token.getTokenId();
    }
}
