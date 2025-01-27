package com.mohsin.repository;

import com.mohsin.entity.Order;
import com.mohsin.entity.User;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findById(Long id);
    List<Order> findByUser(User user);
    void delete(Long id);
    List<Order> findAll();
}
