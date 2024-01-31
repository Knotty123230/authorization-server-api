package com.authorizationserverapi.authorizationserverapi.service;

import com.authorizationserverapi.authorizationserverapi.entity.User;
import com.authorizationserverapi.authorizationserverapi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found with username %s".formatted(username)));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
