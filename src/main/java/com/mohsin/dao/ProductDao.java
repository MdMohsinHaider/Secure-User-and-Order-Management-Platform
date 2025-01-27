package com.mohsin.dao;

import com.mohsin.entity.Product;
import com.mohsin.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProductDao implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product findByName(String name) {
        return entityManager.createQuery("SELECT p FROM ProductEntity p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM ProductEntity p", Product.class)
                .getResultList();
    }
}
