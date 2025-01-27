package com.mohsin.repository;

import com.mohsin.entity.User;

import java.util.List;

/**
 * Repository interface for managing User entities.
 */
public interface UserRepository {

    /**
     * Saves the given User to the repository.
     *
     * @param user the User to save
     */
    void save(User user);

    /**
     * Finds a User by its ID.
     *
     * @param id the ID of the User
     * @return the User with the given ID, or null if not found
     */
    User findById(Long id);

    /**
     * Finds a User by its name.
     *
     * @param name the name of the User
     * @return the User with the given name, or null if not found
     */
    User findByName(String name);

    /**
     * Deletes a User by its ID.
     *
     * @param id the ID of the User to delete
     */
    void delete(Long id);

    /**
     * Retrieves all User entities from the repository.
     *
     * @return a list of all User entities
     */
    List<User> findAll();
}
