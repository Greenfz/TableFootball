package com.fifi.tfmanager.exception.registrationExceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDuplicatedException extends RuntimeException {

    public UserDuplicatedException(String message) {
        super(message);
    }

}
