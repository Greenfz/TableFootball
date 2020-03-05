package com.fifi.tfmanager.security.jwt;

import com.fifi.tfmanager.security.authentication.AuthenticationHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JwtHandler {

    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private AuthenticationHandler authenticationHandler;

    public AuthenticationResponse prepareToken(AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = authenticationHandler.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }
}
