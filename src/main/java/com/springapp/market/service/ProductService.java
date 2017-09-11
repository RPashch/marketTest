package com.springapp.market.service;

import com.springapp.market.model.Product;

import java.util.List;

/**
 * Created on 25.05.2017
 *
 * @author Roman Hayda
 */
public interface ProductService {
     Product getProductById(long id);

     void addProduct(Product product);

     void removeProduct(long id);

     List<Product> listProducts();
}
