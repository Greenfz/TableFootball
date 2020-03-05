package com.fifi.tfmanager.dao;

import com.fifi.tfmanager.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByUserId(long userId);
    User findByEmail(String email);
}
