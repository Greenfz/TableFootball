package com.fifi.tfmanager.exception.registrationExceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserValidationException extends RuntimeException {

    public UserValidationException(String message) {
        super(message);
    }

}
