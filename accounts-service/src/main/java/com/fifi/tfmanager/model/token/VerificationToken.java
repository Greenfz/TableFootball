package com.fifi.tfmanager.model.token;

import com.fifi.tfmanager.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken {

    @Id
    private Long tokenId;

    private String value;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public VerificationToken(String value) {
        this.value = value;
    }

}
