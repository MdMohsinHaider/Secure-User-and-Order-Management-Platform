package com.mohsin.dao;

import com.mohsin.entity.Order;
import com.mohsin.entity.User;
import com.mohsin.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class OrderDao implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            entityManager.persist(order);
        } else {
            entityManager.merge(order);
        }
    }

    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findByUser(User user) {
        return entityManager.createQuery("SELECT o FROM OrderEntity o WHERE o.user = :user", Order.class)
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        Order order = findById(id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("SELECT o FROM OrderEntity o", Order.class)
                .getResultList();
    }
}
