CREATE TABLE client (
                        id varchar(255) NOT NULL,
                        clientId varchar(255) ,
                        clientIdIssuedAt timestamp DEFAULT CURRENT_TIMESTAMP,
                        clientSecret varchar(255) DEFAULT NULL,
                        clientSecretExpiresAt timestamp DEFAULT NULL,
                        clientName varchar(255) ,
                        clientAuthenticationMethods varchar(1000) ,
                        authorizationGrantTypes varchar(1000),
                        redirectUris varchar(1000) DEFAULT NULL,
                        postLogoutRedirectUris varchar(1000) DEFAULT NULL,
                        scopes varchar(1000) ,
                        clientSettings varchar(2000) ,
                        tokenSettings varchar(2000) ,
                        PRIMARY KEY (id)
);
CREATE TABLE authoriztion (
                               id varchar(255) ,
                               registeredClientId varchar(255),
                               principalName varchar(255),
                               authorizationGrantType varchar(255),
                               authorizedScopes varchar(1000) DEFAULT NULL,
                               attributes varchar(4000) DEFAULT NULL,
                               state varchar(500) DEFAULT NULL,
                               authorizationCodeValue varchar(4000) DEFAULT NULL,
                               authorizationCodeIssuedAt timestamp DEFAULT NULL,
                               authorizationCodeExpiresAt timestamp DEFAULT NULL,
                               authorizationCodeMetadata varchar(2000) DEFAULT NULL,
                               accessTokenValue varchar(4000) DEFAULT NULL,
                               accessTokenIssuedAt timestamp DEFAULT NULL,
                               accessTokenExpiresAt timestamp DEFAULT NULL,
                               accessTokenMetadata varchar(2000) DEFAULT NULL,
                               accessTokenType varchar(255) DEFAULT NULL,
                               accessTokenScopes varchar(1000) DEFAULT NULL,
                               refreshTokenValue varchar(4000) DEFAULT NULL,
                               refreshTokenIssuedAt timestamp DEFAULT NULL,
                               refreshTokenExpiresAt timestamp DEFAULT NULL,
                               refreshTokenMetadata varchar(2000) DEFAULT NULL,
                               oidcIdTokenValue varchar(4000) DEFAULT NULL,
                               oidcIdTokenIssuedAt timestamp DEFAULT NULL,
                               oidcIdTokenExpiresAt timestamp DEFAULT NULL,
                               oidcIdTokenMetadata varchar(2000) DEFAULT NULL,
                               oidcIdTokenClaims varchar(2000) DEFAULT NULL,
                               userCodeValue varchar(4000) DEFAULT NULL,
                               userCodeIssuedAt timestamp DEFAULT NULL,
                               userCodeExpiresAt timestamp DEFAULT NULL,
                               userCodeMetadata varchar(2000) DEFAULT NULL,
                               deviceCodeValue varchar(4000) DEFAULT NULL,
                               deviceCodeIssuedAt timestamp DEFAULT NULL,
                               deviceCodeExpiresAt timestamp DEFAULT NULL,
                               deviceCodeMetadata varchar(2000) DEFAULT NULL,
                               PRIMARY KEY (id)
);
CREATE TABLE authorizationConsent (
                                      registeredClientId varchar(255) ,
                                      principalName varchar(255) ,
                                      authorities varchar(1000) ,
                                      PRIMARY KEY (registeredClientId, principalName)
);