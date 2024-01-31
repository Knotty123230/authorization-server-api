package com.authorizationserverapi.authorizationserverapi.config;

import com.authorizationserverapi.authorizationserverapi.jwt_utils.Jwks;
import com.authorizationserverapi.authorizationserverapi.repository.AuthorizationConsentRepository;
import com.authorizationserverapi.authorizationserverapi.repository.AuthorizationRepository;
import com.authorizationserverapi.authorizationserverapi.repository.ClientRepository;
import com.authorizationserverapi.authorizationserverapi.service.JpaOAuth2AuthorizationConsentService;
import com.authorizationserverapi.authorizationserverapi.service.JpaOAuth2AuthorizationService;
import com.authorizationserverapi.authorizationserverapi.service.JpaRegisteredClientRepository;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.oidc.authentication.OidcUserInfoAuthenticationContext;
import org.springframework.security.oauth2.server.authorization.oidc.authentication.OidcUserInfoAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.sql.SQLException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

/**
 * The type Authorization server config.
 */
@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServerConfig.class);

    private static void customize(OAuth2ResourceServerConfigurer<HttpSecurity> httpSecurityOAuth2ResourceServerConfigurer) {
        httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults());
    }


    /**
     * Authorization server security filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
                new OAuth2AuthorizationServerConfigurer();
        RequestMatcher endpointsMatcher = authorizationServerConfigurer
                .getEndpointsMatcher();

        Function<OidcUserInfoAuthenticationContext, OidcUserInfo> userInfoMapper = context -> {
            OidcUserInfoAuthenticationToken authentication = context.getAuthentication();
            JwtAuthenticationToken principal = (JwtAuthenticationToken) authentication.getPrincipal();

            return new OidcUserInfo(principal.getToken().getClaims());
        };

        authorizationServerConfigurer
                .oidc((oidc) -> oidc
                        .userInfoEndpoint(userInfo -> userInfo
                                .userInfoMapper(userInfoMapper)
                        )
                );
        http
                .securityMatcher(endpointsMatcher)
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher))
                .exceptionHandling(exceptions ->
                        exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
                )
                .oauth2ResourceServer(AuthorizationServerConfig::customize)
                .apply((SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity>) authorizationServerConfigurer);
        return http.build();
    }

//    @Bean
//    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder, ClientRepository clientRepository) throws SQLException {
//        Set<String> redirectUris = getRedirectUris();
//
//
//        RegisteredClient demoClientPkceOpaque = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("demo-client-pkce-opaque")
//                .clientSecret(passwordEncoder.encode("secret"))
//                .clientAuthenticationMethods(methods -> methods.addAll(
//                        List.of(
//                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC,
//                                ClientAuthenticationMethod.CLIENT_SECRET_POST,
//                                ClientAuthenticationMethod.NONE
//                        )))
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .tokenSettings(TokenSettings.builder().accessTokenFormat(OAuth2TokenFormat.REFERENCE)
//                        .accessTokenTimeToLive(Duration.ofMinutes(15))
//                        .authorizationCodeTimeToLive(Duration.ofMinutes(2)).build())
//                .redirectUris(uris -> uris.addAll(redirectUris))
//                .scopes(scopes -> scopes.addAll(List.of(
//                        OidcScopes.OPENID, OidcScopes.PROFILE, OidcScopes.EMAIL, "offline_access"
//                )))
//               .clientSettings(ClientSettings.builder().requireProofKey(true).requireAuthorizationConsent(false).build())
//                .build();
//
//        RegisteredClientRepository registeredClientRepository = new JpaRegisteredClientRepository(clientRepository);
//        registeredClientRepository.save(demoClientPkceOpaque);
//
//        LOGGER.info("Registered OAuth2/OIDC clients");
//
//        return registeredClientRepository;
//    }

    private static Set<String> getRedirectUris() {
        Set<String> redirectUris = new HashSet<>();
        redirectUris.add("http://127.0.0.1:9095/client/callback");
        redirectUris.add("http://127.0.0.1:9095/client");
        redirectUris.add("http://127.0.0.1:9090/login/oauth2/code/spring");
        redirectUris.add("http://127.0.0.1:9095/client/login/oauth2/code/spring");
        redirectUris.add("http://localhost:9095/client/callback");
        redirectUris.add("http://localhost:9095/client");
        redirectUris.add("http://localhost:9090/login/oauth2/code/spring");
        redirectUris.add("http://localhost:9095/client/login/oauth2/code/spring");
        redirectUris.add("https://oauth.pstmn.io/v1/callback");
        return redirectUris;
    }


    /**
     * Jwk source jwk source.
     *
     * @return the jwk source
     */
    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        RSAKey rsaKey = Jwks.generateRsa();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    /**
     * Jwt decoder jwt decoder.
     *
     * @param jwkSource the jwk source
     * @return the jwt decoder
     */
    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }

    /**
     * Authorization server settings authorization server settings.
     *
     * @return the authorization server settings
     */
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }

}
