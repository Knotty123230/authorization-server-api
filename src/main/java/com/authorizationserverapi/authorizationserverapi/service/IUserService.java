package com.authorizationserverapi.authorizationserverapi.service;

import com.authorizationserverapi.authorizationserverapi.entity.User;
import org.springframework.stereotype.Service;

/**
 * The interface User service.
 */
public interface IUserService {
    /**
     * Find user by username user.
     *
     * @param username the username
     * @return the user
     */
    User findUserByUsername(String username);

    /**
     * Save user user.
     *
     * @param user the user
     * @return the user
     */
    User saveUser(User user);
}
