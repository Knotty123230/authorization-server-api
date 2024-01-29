package com.authorizationserverapi.authorizationserverapi.repository;

import com.authorizationserverapi.authorizationserverapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}