package com.fifi.tfmanager.dao;

import com.fifi.tfmanager.dao.projection.TokenIdOnly;
import com.fifi.tfmanager.model.token.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends CrudRepository<VerificationToken, Long> {

    VerificationToken findByValue(String value);

//    List<TokenIdOnly> findByValue(String value);

}
