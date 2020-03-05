package com.fifi.tfmanager.exception;

import com.fifi.tfmanager.exception.registrationExceptions.UserDuplicatedException;
import com.fifi.tfmanager.exception.registrationExceptions.UserNotFoundException;
import com.fifi.tfmanager.exception.registrationExceptions.UserValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RegisterExceptionHandler {

    @ExceptionHandler(value = UserValidationException.class)
    public ResponseEntity<Object> handleUserValidationException(UserValidationException ex) {

        ExceptionResponse response = new ExceptionResponse(
                "Invalid credentials - handler message",
                ex,
                HttpStatus.LENGTH_REQUIRED,
                new Date());

        return new ResponseEntity<>(response, HttpStatus.LENGTH_REQUIRED);
    }

    @ExceptionHandler(value = UserDuplicatedException.class)
    public ResponseEntity<Object> handleUserDuplicatedException(UserDuplicatedException ex) {
        ExceptionResponse response = new ExceptionResponse(
                "User already exists - handler message",
                ex,
                HttpStatus.CONFLICT,
                new Date());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(
                "User does not exist",
                ex,
                HttpStatus.NOT_FOUND,
                new Date());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
