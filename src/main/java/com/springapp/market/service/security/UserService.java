package com.springapp.market.service.security;

import com.springapp.market.model.security.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
