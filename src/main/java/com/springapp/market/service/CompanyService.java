package com.springapp.market.service;

import com.springapp.market.model.Company;
import com.springapp.market.model.Product;

import java.util.List;

/**
 * Created on 24.05.2017
 *
 * Service class for {@link com.springapp.market.model.Company}.
 * @author Roman Hayda
 */
public interface CompanyService {

    Company getCompanyById(long id);

    void addCompany(Company company);

    void removeCompany(long id);

    List<Company> listCompanies();

    List<Product> getProductsByCompanyId(long id);
}
