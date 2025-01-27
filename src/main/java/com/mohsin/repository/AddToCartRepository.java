package com.mohsin.repository;

import com.mohsin.entity.AddToCart;
import com.mohsin.entity.Product;
import com.mohsin.entity.User;

import java.util.List;

public interface AddToCartRepository {
    void save(AddToCart addToCart);
    AddToCart findById(Long id);
    AddToCart findByUserAndProduct(User user, Product product);
    void delete(Long id);
    List<AddToCart> findAll();
}
