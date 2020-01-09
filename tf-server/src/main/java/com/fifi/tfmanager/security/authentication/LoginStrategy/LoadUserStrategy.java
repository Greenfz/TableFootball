package com.fifi.tfmanager.security.authentication.LoginStrategy;

import com.fifi.tfmanager.model.user.User;

public interface LoadUserStrategy {

    User loadUser(String userData);
}
