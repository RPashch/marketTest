package com.springapp.market.service;

import com.springapp.market.model.Product;

import java.util.List;


public interface ProductService {
     Product getProductById(long id);

     void addProduct(Product product);

     void removeProduct(long id);

     List<Product> listProducts();
}
