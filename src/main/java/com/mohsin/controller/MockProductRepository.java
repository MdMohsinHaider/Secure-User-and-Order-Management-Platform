package com.mohsin.controller;

import com.mohsin.entity.Product;
import com.mohsin.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

class MockProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void delete(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}

