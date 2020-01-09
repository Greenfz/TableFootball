package com.fifi.tfmanager.controller;


import com.fifi.tfmanager.exception.registrationExceptions.UserValidationException;
import com.fifi.tfmanager.model.user.User;
import com.fifi.tfmanager.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Slf4j
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    ResponseEntity<Boolean> processRegister(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserValidationException();
        } else {
            registrationService.registerUser(user);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
    }

    @GetMapping("/register")
    public String verification(@RequestParam String token) {
        registrationService.enableByToken(token);
        return "return";
    }
}
