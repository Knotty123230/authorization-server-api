package com.authorizationserverapi.authorizationserverapi.repository;

import com.authorizationserverapi.authorizationserverapi.entity.AuthorizationConsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Authorization consent repository.
 */
@Repository
public interface AuthorizationConsentRepository extends JpaRepository<AuthorizationConsent, AuthorizationConsent.AuthorizationConsentId> {
    /**
     * Find by registered client id and principal name optional.
     *
     * @param registeredClientId the registered client id
     * @param principalName      the principal name
     * @return the optional
     */
    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);

    /**
     * Delete by registered client id and principal name.
     *
     * @param registeredClientId the registered client id
     * @param principalName      the principal name
     */
    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
