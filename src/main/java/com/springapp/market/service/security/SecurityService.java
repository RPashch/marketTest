package com.springapp.market.service.security;

/**
 * Created on 25.05.2017
 *
 * Service for Security.
 *
 * @author Roman Hayda
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
