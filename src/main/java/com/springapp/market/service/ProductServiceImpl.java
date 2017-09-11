package com.springapp.market.service;

import com.springapp.market.dao.ProductDao;
import com.springapp.market.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 25.05.2017
 *
 * mplementation of {@link ProductService} interface.
 *
 * @author Roman Hayda
 */
@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public Product getProductById(long id) {
        return productDao.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addProduct(Product product) {
        productDao.saveAndFlush(product);
    }

    @Override
    @Transactional
    public void removeProduct(long id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return productDao.findAll();
    }
}
