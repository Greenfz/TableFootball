package com.fifi.tfmanager.model.user;

import com.fifi.tfmanager.model.token.VerificationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NullObjectUser extends User {

    @Override
    public void setEmail(@Email String email) {
    }

    @Override
    public void setEnabled(boolean enabled) {
    }

    @Override
    public void setPassword(@NotBlank String password) {
    }

    @Override
    public void setRole(String role) {
    }

    @Override
    public void setUsername(@NotBlank @Size(min = 3, max = 15) String username) {
    }

    @Override
    public void setUserId(Long userId) {
    }

    @Override
    public void setVerificationToken(VerificationToken verificationToken) {
    }
}
