package com.mohsin.dao;

import com.mohsin.entity.AddToCart;
import com.mohsin.entity.Product;
import com.mohsin.entity.User;
import com.mohsin.repository.AadharCardRepository;
import com.mohsin.repository.AddToCartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class AddToCartDao implements AddToCartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AddToCart addToCart) {
        if (addToCart.getId() == null) {
            entityManager.persist(addToCart);
        } else {
            entityManager.merge(addToCart);
        }
    }

    @Override
    public AddToCart findById(Long id) {
        return entityManager.find(AddToCart.class, id);
    }

    @Override
    public AddToCart findByUserAndProduct(User user, Product product) {
        return entityManager.createQuery("SELECT a FROM AddToCartEntity a WHERE a.user = :user AND a.product = :product", AddToCart.class)
                .setParameter("user", user)
                .setParameter("product", product)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        AddToCart addToCart = findById(id);
        if (addToCart != null) {
            entityManager.remove(addToCart);
        }
    }

    @Override
    public List<AddToCart> findAll() {
        return entityManager.createQuery("SELECT a FROM AddToCartEntity a", AddToCart.class)
                .getResultList();
    }
}
