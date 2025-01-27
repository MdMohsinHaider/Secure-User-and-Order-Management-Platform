package com.mohsin.repository;

import com.mohsin.entity.AadharCard;

import java.util.List;

/**
 * Repository interface for managing AadharCard entities.
 */
public interface AadharCardRepository {

    /**
     * Saves the given AadharCard to the repository.
     *
     * @param aadharCard the AadharCard to save
     */
    void save(AadharCard aadharCard);

    /**
     * Finds an AadharCard by its ID.
     *
     * @param id the ID of the AadharCard
     * @return the AadharCard with the given ID, or null if not found
     */
    AadharCard findById(Long id);

    /**
     * Finds an AadharCard by its Aadhar number.
     *
     * @param aadharNumber the Aadhar number of the AadharCard
     * @return the AadharCard with the given Aadhar number, or null if not found
     */
    AadharCard findByAadharNumber(String aadharNumber);

    /**
     * Deletes an AadharCard by its ID.
     *
     * @param id the ID of the AadharCard to delete
     */
    void delete(Long id);

    /**
     * Retrieves all AadharCard entities from the repository.
     *
     * @return a list of all AadharCard entities
     */
    List<AadharCard> findAll();
}
