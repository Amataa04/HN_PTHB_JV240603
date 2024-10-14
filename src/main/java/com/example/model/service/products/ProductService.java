package com.example.model.service.products;


import com.example.model.entity.products.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean add(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean delete(int id);
}
