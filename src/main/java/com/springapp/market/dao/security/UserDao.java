package com.springapp.market.dao.security;

import com.springapp.market.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
