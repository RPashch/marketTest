package com.springapp.market.service.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
