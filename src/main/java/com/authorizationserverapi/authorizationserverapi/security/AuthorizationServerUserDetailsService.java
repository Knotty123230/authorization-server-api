package com.authorizationserverapi.authorizationserverapi.security;

import com.authorizationserverapi.authorizationserverapi.entity.User;
import com.authorizationserverapi.authorizationserverapi.entity.UserRole;
import com.authorizationserverapi.authorizationserverapi.service.IUserService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * The type Authorization server user details service.
 */
@Service
public class AuthorizationServerUserDetailsService implements UserDetailsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServerUserDetailsService.class);
    private final IUserService userService;

    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Authorization server user details service.
     *
     * @param userService     the user service
     * @param passwordEncoder the password encoder
     */
    public AuthorizationServerUserDetailsService(IUserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
//
//    @PostConstruct
//    public void initUsers() {
//
//        User bWayne = new User(UUID.randomUUID(), "bwayne", passwordEncoder.encode("wayne"),
//                "Bruce", "Wayne", "bruce.wayne@example.com", Set.of(UserRole.USER));
//        Set<String> cKentRoles = new HashSet<>();
//        cKentRoles.add("USER");
//        User cKent = new User(UUID.randomUUID(), "ckent", passwordEncoder.encode("kent"),
//                "Clark", "Kent", "clark.kent@example.com", Set.of(UserRole.ADMIN, UserRole.USER));
//        Set<String> pParkerRoles = new HashSet<>();
//        pParkerRoles.add("USER");
//        pParkerRoles.add("ADMIN");
//        User pParker = new User(UUID.randomUUID(), "pparker", passwordEncoder.encode("parker"),
//                "Peter", "Parker", "peter.parker@example.com", Set.of(UserRole.USER));
//
//        userService.saveUser(bWayne);
//        LOGGER.info("Initialized users {}, {} and {}", bWayne, cKent, pParker);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findUserByUsername(username);
    }
}
