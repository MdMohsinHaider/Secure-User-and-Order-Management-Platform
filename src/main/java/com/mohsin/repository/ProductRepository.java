package com.mohsin.repository;

import com.mohsin.entity.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
    Product findByName(String name);
    void delete(Long id);
    List<Product> findAll();
}
