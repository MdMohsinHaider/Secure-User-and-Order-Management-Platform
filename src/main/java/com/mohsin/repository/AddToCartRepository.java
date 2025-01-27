package com.mohsin.repository;

import com.mohsin.entity.AddToCart;
import com.mohsin.entity.Product;
import com.mohsin.entity.User;

import java.util.List;

/**
 * Repository interface for managing AddToCart entities.
 */
public interface AddToCartRepository {

    /**
     * Saves the given AddToCart to the repository.
     *
     * @param addToCart the AddToCart entity to save
     */
    void save(AddToCart addToCart);

    /**
     * Finds an AddToCart by its ID.
     *
     * @param id the ID of the AddToCart entity
     * @return the AddToCart entity with the given ID, or null if not found
     */
    AddToCart findById(Long id);

    /**
     * Finds an AddToCart by the user and product.
     *
     * @param user the User associated with the AddToCart
     * @param product the Product associated with the AddToCart
     * @return the AddToCart entity with the given user and product, or null if not found
     */
    AddToCart findByUserAndProduct(User user, Product product);

    /**
     * Deletes an AddToCart by its ID.
     *
     * @param id the ID of the AddToCart entity to delete
     */
    void delete(Long id);

    /**
     * Retrieves all AddToCart entities from the repository.
     *
     * @return a list of all AddToCart entities
     */
    List<AddToCart> findAll();
}
