package com.authorizationserverapi.authorizationserverapi.service;

import com.authorizationserverapi.authorizationserverapi.entity.User;
import org.springframework.stereotype.Service;

public interface IUserService {
    User findUserByUsername(String username);
    User saveUser(User user);
}
