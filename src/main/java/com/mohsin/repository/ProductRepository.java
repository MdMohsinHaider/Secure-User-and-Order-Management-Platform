package com.mohsin.repository;

import com.mohsin.entity.Product;

import java.util.List;

/**
 * Repository interface for managing Product entities.
 */
public interface ProductRepository {

    /**
     * Saves the given Product to the repository.
     *
     * @param product the Product to save
     */
    void save(Product product);

    /**
     * Finds a Product by its ID.
     *
     * @param id the ID of the Product
     * @return the Product with the given ID, or null if not found
     */
    Product findById(Long id);

    /**
     * Finds a Product by its name.
     *
     * @param name the name of the Product
     * @return the Product with the given name, or null if not found
     */
    Product findByName(String name);

    /**
     * Deletes a Product by its ID.
     *
     * @param id the ID of the Product to delete
     */
    void delete(Long id);

    /**
     * Retrieves all Product entities from the repository.
     *
     * @return a list of all Product entities
     */
    List<Product> findAll();
}
