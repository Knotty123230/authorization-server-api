package com.authorizationserverapi.authorizationserverapi.repository;

import com.authorizationserverapi.authorizationserverapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
