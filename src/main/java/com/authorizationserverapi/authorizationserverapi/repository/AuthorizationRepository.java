package com.authorizationserverapi.authorizationserverapi.repository;

import com.authorizationserverapi.authorizationserverapi.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Authorization repository.
 */
@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, String> {
    /**
     * Find by state optional.
     *
     * @param state the state
     * @return the optional
     */
    Optional<Authorization> findByState(String state);

    /**
     * Find by authorization code value optional.
     *
     * @param authorizationCode the authorization code
     * @return the optional
     */
    Optional<Authorization> findByAuthorizationCodeValue(String authorizationCode);

    /**
     * Find by access token value optional.
     *
     * @param accessToken the access token
     * @return the optional
     */
    Optional<Authorization> findByAccessTokenValue(String accessToken);

    /**
     * Find by refresh token value optional.
     *
     * @param refreshToken the refresh token
     * @return the optional
     */
    Optional<Authorization> findByRefreshTokenValue(String refreshToken);

    /**
     * Find by oidc id token value optional.
     *
     * @param idToken the id token
     * @return the optional
     */
    Optional<Authorization> findByOidcIdTokenValue(String idToken);

    /**
     * Find by user code value optional.
     *
     * @param userCode the user code
     * @return the optional
     */
    Optional<Authorization> findByUserCodeValue(String userCode);

    /**
     * Find by device code value optional.
     *
     * @param deviceCode the device code
     * @return the optional
     */
    Optional<Authorization> findByDeviceCodeValue(String deviceCode);

    /**
     * Find by state or authorization code value or access token value or refresh token value or oidc id token value or user code value or device code value optional.
     *
     * @param token the token
     * @return the optional
     */
    @Query("select a from Authorization a where a.state = :token" +
            " or a.authorizationCodeValue = :token" +
            " or a.accessTokenValue = :token" +
            " or a.refreshTokenValue = :token" +
            " or a.oidcIdTokenValue = :token" +
            " or a.userCodeValue = :token" +
            " or a.deviceCodeValue = :token"
    )
    Optional<Authorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValueOrOidcIdTokenValueOrUserCodeValueOrDeviceCodeValue(@Param("token") String token);
}
