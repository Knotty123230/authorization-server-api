package com.authorizationserverapi.authorizationserverapi.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Authorization consent.
 */
@Entity
@Table(name = "`authorizationConsent`")
@IdClass(AuthorizationConsent.AuthorizationConsentId.class)
public class AuthorizationConsent {
    @Id
    private String registeredClientId;
    @Id
    private String principalName;
    @Column(length = 1000)
    private String authorities;

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
     * Gets authorities.
     *
     * @return the authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * Sets authorities.
     *
     * @param authorities the authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * The type Authorization consent id.
     */
    public static class AuthorizationConsentId implements Serializable {
        private String registeredClientId;
        private String principalName;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AuthorizationConsentId that = (AuthorizationConsentId) o;
            return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(registeredClientId, principalName);
        }
    }
}