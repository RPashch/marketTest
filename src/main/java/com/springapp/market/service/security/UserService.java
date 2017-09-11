package com.springapp.market.service.security;

import com.springapp.market.model.security.User;

/**
 * Created on 24.05.2017
 *
 * Service class for {@link com.springapp.market.model.security.User}.
 *
 * @author Roman Hayda
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
