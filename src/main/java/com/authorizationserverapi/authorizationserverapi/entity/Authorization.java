package com.authorizationserverapi.authorizationserverapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

/**
 * The type Authorization.
 */
@Entity
@Table(name = "authoriztion")
public class Authorization {
    @Id
    @Column
    private String id;
    private String registeredClientId;
    private String principalName;
    private String authorizationGrantType;
    @Column(length = 1000)
    private String authorizedScopes;
    @Column(length = 4000)
    private String attributes;
    @Column(length = 500)
    private String state;

    @Column(length = 4000)
    private String authorizationCodeValue;
    private Instant authorizationCodeIssuedAt;
    private Instant authorizationCodeExpiresAt;
    private String authorizationCodeMetadata;

    @Column(length = 4000)
    private String accessTokenValue;
    private Instant accessTokenIssuedAt;
    private Instant accessTokenExpiresAt;
    @Column(length = 2000)
    private String accessTokenMetadata;
    private String accessTokenType;
    @Column(length = 1000)
    private String accessTokenScopes;

    @Column(length = 4000)
    private String refreshTokenValue;
    private Instant refreshTokenIssuedAt;
    private Instant refreshTokenExpiresAt;
    @Column(length = 2000)
    private String refreshTokenMetadata;

    @Column(length = 4000)
    private String oidcIdTokenValue;
    private Instant oidcIdTokenIssuedAt;
    private Instant oidcIdTokenExpiresAt;
    @Column(length = 2000)
    private String oidcIdTokenMetadata;
    @Column(length = 2000)
    private String oidcIdTokenClaims;

    @Column(length = 4000)
    private String userCodeValue;
    private Instant userCodeIssuedAt;
    private Instant userCodeExpiresAt;
    @Column(length = 2000)
    private String userCodeMetadata;

    @Column(length = 4000)
    private String deviceCodeValue;
    private Instant deviceCodeIssuedAt;
    private Instant deviceCodeExpiresAt;
    @Column(length = 2000)
    private String deviceCodeMetadata;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets registered client id.
     *
     * @return the registered client id
     */
    public String getRegisteredClientId() {
        return registeredClientId;
    }

    /**
     * Sets registered client id.
     *
     * @param registeredClientId the registered client id
     */
    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    /**
     * Gets principal name.
     *
     * @return the principal name
     */
    public String getPrincipalName() {
        return principalName;
    }

    /**
     * Sets principal name.
     *
     * @param principalName the principal name
     */
    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    /**
     * Gets authorization grant type.
     *
     * @return the authorization grant type
     */
    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    /**
     * Sets authorization grant type.
     *
     * @param authorizationGrantType the authorization grant type
     */
    public void setAuthorizationGrantType(String authorizationGrantType) {
        this.authorizationGrantType = authorizationGrantType;
    }

    /**
     * Gets authorized scopes.
     *
     * @return the authorized scopes
     */
    public String getAuthorizedScopes() {
        return this.authorizedScopes;
    }

    /**
     * Sets authorized scopes.
     *
     * @param authorizedScopes the authorized scopes
     */
    public void setAuthorizedScopes(String authorizedScopes) {
        this.authorizedScopes = authorizedScopes;
    }

    /**
     * Gets attributes.
     *
     * @return the attributes
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets authorization code value.
     *
     * @return the authorization code value
     */
    public String getAuthorizationCodeValue() {
        return authorizationCodeValue;
    }

    /**
     * Sets authorization code value.
     *
     * @param authorizationCode the authorization code
     */
    public void setAuthorizationCodeValue(String authorizationCode) {
        this.authorizationCodeValue = authorizationCode;
    }

    /**
     * Gets authorization code issued at.
     *
     * @return the authorization code issued at
     */
    public Instant getAuthorizationCodeIssuedAt() {
        return authorizationCodeIssuedAt;
    }

    /**
     * Sets authorization code issued at.
     *
     * @param authorizationCodeIssuedAt the authorization code issued at
     */
    public void setAuthorizationCodeIssuedAt(Instant authorizationCodeIssuedAt) {
        this.authorizationCodeIssuedAt = authorizationCodeIssuedAt;
    }

    /**
     * Gets authorization code expires at.
     *
     * @return the authorization code expires at
     */
    public Instant getAuthorizationCodeExpiresAt() {
        return authorizationCodeExpiresAt;
    }

    /**
     * Sets authorization code expires at.
     *
     * @param authorizationCodeExpiresAt the authorization code expires at
     */
    public void setAuthorizationCodeExpiresAt(Instant authorizationCodeExpiresAt) {
        this.authorizationCodeExpiresAt = authorizationCodeExpiresAt;
    }

    /**
     * Gets authorization code metadata.
     *
     * @return the authorization code metadata
     */
    public String getAuthorizationCodeMetadata() {
        return authorizationCodeMetadata;
    }

    /**
     * Sets authorization code metadata.
     *
     * @param authorizationCodeMetadata the authorization code metadata
     */
    public void setAuthorizationCodeMetadata(String authorizationCodeMetadata) {
        this.authorizationCodeMetadata = authorizationCodeMetadata;
    }

    /**
     * Gets access token value.
     *
     * @return the access token value
     */
    public String getAccessTokenValue() {
        return accessTokenValue;
    }

    /**
     * Sets access token value.
     *
     * @param accessToken the access token
     */
    public void setAccessTokenValue(String accessToken) {
        this.accessTokenValue = accessToken;
    }

    /**
     * Gets access token issued at.
     *
     * @return the access token issued at
     */
    public Instant getAccessTokenIssuedAt() {
        return accessTokenIssuedAt;
    }

    /**
     * Sets access token issued at.
     *
     * @param accessTokenIssuedAt the access token issued at
     */
    public void setAccessTokenIssuedAt(Instant accessTokenIssuedAt) {
        this.accessTokenIssuedAt = accessTokenIssuedAt;
    }

    /**
     * Gets access token expires at.
     *
     * @return the access token expires at
     */
    public Instant getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    /**
     * Sets access token expires at.
     *
     * @param accessTokenExpiresAt the access token expires at
     */
    public void setAccessTokenExpiresAt(Instant accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    /**
     * Gets access token metadata.
     *
     * @return the access token metadata
     */
    public String getAccessTokenMetadata() {
        return accessTokenMetadata;
    }

    /**
     * Sets access token metadata.
     *
     * @param accessTokenMetadata the access token metadata
     */
    public void setAccessTokenMetadata(String accessTokenMetadata) {
        this.accessTokenMetadata = accessTokenMetadata;
    }

    /**
     * Gets access token type.
     *
     * @return the access token type
     */
    public String getAccessTokenType() {
        return accessTokenType;
    }

    /**
     * Sets access token type.
     *
     * @param accessTokenType the access token type
     */
    public void setAccessTokenType(String accessTokenType) {
        this.accessTokenType = accessTokenType;
    }

    /**
     * Gets access token scopes.
     *
     * @return the access token scopes
     */
    public String getAccessTokenScopes() {
        return accessTokenScopes;
    }

    /**
     * Sets access token scopes.
     *
     * @param accessTokenScopes the access token scopes
     */
    public void setAccessTokenScopes(String accessTokenScopes) {
        this.accessTokenScopes = accessTokenScopes;
    }

    /**
     * Gets refresh token value.
     *
     * @return the refresh token value
     */
    public String getRefreshTokenValue() {
        return refreshTokenValue;
    }

    /**
     * Sets refresh token value.
     *
     * @param refreshToken the refresh token
     */
    public void setRefreshTokenValue(String refreshToken) {
        this.refreshTokenValue = refreshToken;
    }

    /**
     * Gets refresh token issued at.
     *
     * @return the refresh token issued at
     */
    public Instant getRefreshTokenIssuedAt() {
        return refreshTokenIssuedAt;
    }

    /**
     * Sets refresh token issued at.
     *
     * @param refreshTokenIssuedAt the refresh token issued at
     */
    public void setRefreshTokenIssuedAt(Instant refreshTokenIssuedAt) {
        this.refreshTokenIssuedAt = refreshTokenIssuedAt;
    }

    /**
     * Gets refresh token expires at.
     *
     * @return the refresh token expires at
     */
    public Instant getRefreshTokenExpiresAt() {
        return refreshTokenExpiresAt;
    }

    /**
     * Sets refresh token expires at.
     *
     * @param refreshTokenExpiresAt the refresh token expires at
     */
    public void setRefreshTokenExpiresAt(Instant refreshTokenExpiresAt) {
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
    }

    /**
     * Gets refresh token metadata.
     *
     * @return the refresh token metadata
     */
    public String getRefreshTokenMetadata() {
        return refreshTokenMetadata;
    }

    /**
     * Sets refresh token metadata.
     *
     * @param refreshTokenMetadata the refresh token metadata
     */
    public void setRefreshTokenMetadata(String refreshTokenMetadata) {
        this.refreshTokenMetadata = refreshTokenMetadata;
    }

    /**
     * Gets oidc id token value.
     *
     * @return the oidc id token value
     */
    public String getOidcIdTokenValue() {
        return oidcIdTokenValue;
    }

    /**
     * Sets oidc id token value.
     *
     * @param idToken the id token
     */
    public void setOidcIdTokenValue(String idToken) {
        this.oidcIdTokenValue = idToken;
    }

    /**
     * Gets oidc id token issued at.
     *
     * @return the oidc id token issued at
     */
    public Instant getOidcIdTokenIssuedAt() {
        return oidcIdTokenIssuedAt;
    }

    /**
     * Sets oidc id token issued at.
     *
     * @param idTokenIssuedAt the id token issued at
     */
    public void setOidcIdTokenIssuedAt(Instant idTokenIssuedAt) {
        this.oidcIdTokenIssuedAt = idTokenIssuedAt;
    }

    /**
     * Gets oidc id token expires at.
     *
     * @return the oidc id token expires at
     */
    public Instant getOidcIdTokenExpiresAt() {
        return oidcIdTokenExpiresAt;
    }

    /**
     * Sets oidc id token expires at.
     *
     * @param idTokenExpiresAt the id token expires at
     */
    public void setOidcIdTokenExpiresAt(Instant idTokenExpiresAt) {
        this.oidcIdTokenExpiresAt = idTokenExpiresAt;
    }

    /**
     * Gets oidc id token metadata.
     *
     * @return the oidc id token metadata
     */
    public String getOidcIdTokenMetadata() {
        return oidcIdTokenMetadata;
    }

    /**
     * Sets oidc id token metadata.
     *
     * @param idTokenMetadata the id token metadata
     */
    public void setOidcIdTokenMetadata(String idTokenMetadata) {
        this.oidcIdTokenMetadata = idTokenMetadata;
    }

    /**
     * Gets oidc id token claims.
     *
     * @return the oidc id token claims
     */
    public String getOidcIdTokenClaims() {
        return oidcIdTokenClaims;
    }

    /**
     * Sets oidc id token claims.
     *
     * @param idTokenClaims the id token claims
     */
    public void setOidcIdTokenClaims(String idTokenClaims) {
        this.oidcIdTokenClaims = idTokenClaims;
    }

    /**
     * Gets user code value.
     *
     * @return the user code value
     */
    public String getUserCodeValue() {
        return this.userCodeValue;
    }

    /**
     * Sets user code value.
     *
     * @param userCodeValue the user code value
     */
    public void setUserCodeValue(String userCodeValue) {
        this.userCodeValue = userCodeValue;
    }

    /**
     * Gets user code issued at.
     *
     * @return the user code issued at
     */
    public Instant getUserCodeIssuedAt() {
        return this.userCodeIssuedAt;
    }

    /**
     * Sets user code issued at.
     *
     * @param userCodeIssuedAt the user code issued at
     */
    public void setUserCodeIssuedAt(Instant userCodeIssuedAt) {
        this.userCodeIssuedAt = userCodeIssuedAt;
    }

    /**
     * Gets user code expires at.
     *
     * @return the user code expires at
     */
    public Instant getUserCodeExpiresAt() {
        return this.userCodeExpiresAt;
    }

    /**
     * Sets user code expires at.
     *
     * @param userCodeExpiresAt the user code expires at
     */
    public void setUserCodeExpiresAt(Instant userCodeExpiresAt) {
        this.userCodeExpiresAt = userCodeExpiresAt;
    }

    /**
     * Gets user code metadata.
     *
     * @return the user code metadata
     */
    public String getUserCodeMetadata() {
        return this.userCodeMetadata;
    }

    /**
     * Sets user code metadata.
     *
     * @param userCodeMetadata the user code metadata
     */
    public void setUserCodeMetadata(String userCodeMetadata) {
        this.userCodeMetadata = userCodeMetadata;
    }

    /**
     * Gets device code value.
     *
     * @return the device code value
     */
    public String getDeviceCodeValue() {
        return this.deviceCodeValue;
    }

    /**
     * Sets device code value.
     *
     * @param deviceCodeValue the device code value
     */
    public void setDeviceCodeValue(String deviceCodeValue) {
        this.deviceCodeValue = deviceCodeValue;
    }

    /**
     * Gets device code issued at.
     *
     * @return the device code issued at
     */
    public Instant getDeviceCodeIssuedAt() {
        return this.deviceCodeIssuedAt;
    }

    /**
     * Sets device code issued at.
     *
     * @param deviceCodeIssuedAt the device code issued at
     */
    public void setDeviceCodeIssuedAt(Instant deviceCodeIssuedAt) {
        this.deviceCodeIssuedAt = deviceCodeIssuedAt;
    }

    /**
     * Gets device code expires at.
     *
     * @return the device code expires at
     */
    public Instant getDeviceCodeExpiresAt() {
        return this.deviceCodeExpiresAt;
    }

    /**
     * Sets device code expires at.
     *
     * @param deviceCodeExpiresAt the device code expires at
     */
    public void setDeviceCodeExpiresAt(Instant deviceCodeExpiresAt) {
        this.deviceCodeExpiresAt = deviceCodeExpiresAt;
    }

    /**
     * Gets device code metadata.
     *
     * @return the device code metadata
     */
    public String getDeviceCodeMetadata() {
        return this.deviceCodeMetadata;
    }

    /**
     * Sets device code metadata.
     *
     * @param deviceCodeMetadata the device code metadata
     */
    public void setDeviceCodeMetadata(String deviceCodeMetadata) {
        this.deviceCodeMetadata = deviceCodeMetadata;
    }
}
