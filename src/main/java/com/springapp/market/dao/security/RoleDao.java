package com.springapp.market.dao.security;

import com.springapp.market.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 25.05.2017
 *
 * @author Roman Hayda
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
