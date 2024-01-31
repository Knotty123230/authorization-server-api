package com.authorizationserverapi.authorizationserverapi.repository;

import com.authorizationserverapi.authorizationserverapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends JpaRepository<Client, String> {
    /**
     * Find by client id optional.
     *
     * @param clientId the client id
     * @return the optional
     */
    Optional<Client> findByClientId(String clientId);
}
