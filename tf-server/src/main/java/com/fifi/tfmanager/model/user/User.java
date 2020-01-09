package com.fifi.tfmanager.model.user;

import com.fifi.tfmanager.model.token.VerificationToken;
import com.fifi.tfmanager.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @ValidPassword
    private String password;

    @Email
    private String email;

    private String role = "user";

    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private VerificationToken verificationToken;
}
