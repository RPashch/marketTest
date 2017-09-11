package com.springapp.market.dao;

import com.springapp.market.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created on 25.05.2017
 *
 * @author Roman Hayda
 */
public interface CompanyDao extends JpaRepository<Company, Long> {

    @Override
    @Query("select c from Company c left join fetch c.products where c.id = :id")
    Company getOne(@Param("id") Long id);

}
