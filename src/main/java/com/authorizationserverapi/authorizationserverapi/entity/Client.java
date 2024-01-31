package com.authorizationserverapi.authorizationserverapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

/**
 * The type Client.
 */
@Entity
@Table(name = "`client`")
public class Client {
    @Id
    private String id;
    private String clientId;
    private Instant clientIdIssuedAt;
    private String clientSecret;
    private Instant clientSecretExpiresAt;
    private String clientName;
    @Column(length = 1000)
    private String clientAuthenticationMethods;
    @Column(length = 1000)
    private String authorizationGrantTypes;
    @Column(length = 1000)
    private String redirectUris;
    @Column(length = 1000)
    private String postLogoutRedirectUris;
    @Column(length = 1000)
    private String scopes;
    @Column(length = 2000)
    private String clientSettings;
    @Column(length = 2000)
    private String tokenSettings;

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
     * Gets client id.
     *
     * @return the client id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets client id issued at.
     *
     * @return the client id issued at
     */
    public Instant getClientIdIssuedAt() {
        return clientIdIssuedAt;
    }

    /**
     * Sets client id issued at.
     *
     * @param clientIdIssuedAt the client id issued at
     */
    public void setClientIdIssuedAt(Instant clientIdIssuedAt) {
        this.clientIdIssuedAt = clientIdIssuedAt;
    }

    /**
     * Gets client secret.
     *
     * @return the client secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Sets client secret.
     *
     * @param clientSecret the client secret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Gets client secret expires at.
     *
     * @return the client secret expires at
     */
    public Instant getClientSecretExpiresAt() {
        return clientSecretExpiresAt;
    }

    /**
     * Sets client secret expires at.
     *
     * @param clientSecretExpiresAt the client secret expires at
     */
    public void setClientSecretExpiresAt(Instant clientSecretExpiresAt) {
        this.clientSecretExpiresAt = clientSecretExpiresAt;
    }

    /**
     * Gets client name.
     *
     * @return the client name
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets client name.
     *
     * @param clientName the client name
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Gets client authentication methods.
     *
     * @return the client authentication methods
     */
    public String getClientAuthenticationMethods() {
        return clientAuthenticationMethods;
    }

    /**
     * Sets client authentication methods.
     *
     * @param clientAuthenticationMethods the client authentication methods
     */
    public void setClientAuthenticationMethods(String clientAuthenticationMethods) {
        this.clientAuthenticationMethods = clientAuthenticationMethods;
    }

    /**
     * Gets authorization grant types.
     *
     * @return the authorization grant types
     */
    public String getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }

    /**
     * Sets authorization grant types.
     *
     * @param authorizationGrantTypes the authorization grant types
     */
    public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }

    /**
     * Gets redirect uris.
     *
     * @return the redirect uris
     */
    public String getRedirectUris() {
        return redirectUris;
    }

    /**
     * Sets redirect uris.
     *
     * @param redirectUris the redirect uris
     */
    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    /**
     * Gets post logout redirect uris.
     *
     * @return the post logout redirect uris
     */
    public String getPostLogoutRedirectUris() {
        return this.postLogoutRedirectUris;
    }

    /**
     * Sets post logout redirect uris.
     *
     * @param postLogoutRedirectUris the post logout redirect uris
     */
    public void setPostLogoutRedirectUris(String postLogoutRedirectUris) {
        this.postLogoutRedirectUris = postLogoutRedirectUris;
    }

    /**
     * Gets scopes.
     *
     * @return the scopes
     */
    public String getScopes() {
        return scopes;
    }

    /**
     * Sets scopes.
     *
     * @param scopes the scopes
     */
    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    /**
     * Gets client settings.
     *
     * @return the client settings
     */
    public String getClientSettings() {
        return clientSettings;
    }

    /**
     * Sets client settings.
     *
     * @param clientSettings the client settings
     */
    public void setClientSettings(String clientSettings) {
        this.clientSettings = clientSettings;
    }

    /**
     * Gets token settings.
     *
     * @return the token settings
     */
    public String getTokenSettings() {
        return tokenSettings;
    }

    /**
     * Sets token settings.
     *
     * @param tokenSettings the token settings
     */
    public void setTokenSettings(String tokenSettings) {
        this.tokenSettings = tokenSettings;
    }
}
