package com.mohsin.controller;

import com.mohsin.entity.AddToCart;
import com.mohsin.entity.Product;
import com.mohsin.entity.User;
import com.mohsin.repository.AddToCartRepository;

import java.util.ArrayList;
import java.util.List;

class MockAddToCartRepository implements AddToCartRepository {
    private List<AddToCart> cartItems = new ArrayList<>();

    @Override
    public void save(AddToCart addToCart) {
        cartItems.add(addToCart);
    }

    @Override
    public AddToCart findById(Long id) {
        return cartItems.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public AddToCart findByUserAndProduct(User user, Product product) {
        return cartItems.stream().filter(c -> c.getUser().equals(user) && c.getProduct().equals(product)).findFirst().orElse(null);
    }

    @Override
    public void delete(Long id) {
        cartItems.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<AddToCart> findAll() {
        return cartItems;
    }
}