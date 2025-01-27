package com.mohsin.controller;

import com.mohsin.entity.Order;
import com.mohsin.entity.User;
import com.mohsin.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

class MockOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public Order findById(Long id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orders.stream().filter(o -> o.getUser().equals(user)).toList();
    }

    @Override
    public void delete(Long id) {
        orders.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
