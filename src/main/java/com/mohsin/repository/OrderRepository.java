package com.mohsin.repository;

import com.mohsin.entity.Order;
import com.mohsin.entity.User;

import java.util.List;

/**
 * Repository interface for managing Order entities.
 */
public interface OrderRepository {

    /**
     * Saves the given Order to the repository.
     *
     * @param order the Order entity to save
     */
    void save(Order order);

    /**
     * Finds an Order by its ID.
     *
     * @param id the ID of the Order entity
     * @return the Order with the given ID, or null if not found
     */
    Order findById(Long id);

    /**
     * Finds all Orders for a given User.
     *
     * @param user the User whose Orders are to be retrieved
     * @return a list of Orders associated with the given User
     */
    List<Order> findByUser(User user);

    /**
     * Deletes an Order by its ID.
     *
     * @param id the ID of the Order entity to delete
     */
    void delete(Long id);

    /**
     * Retrieves all Order entities from the repository.
     *
     * @return a list of all Order entities
     */
    List<Order> findAll();
}
