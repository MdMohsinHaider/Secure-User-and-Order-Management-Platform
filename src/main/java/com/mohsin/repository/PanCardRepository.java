package com.mohsin.repository;

import com.mohsin.entity.PanCard;

import java.util.List;

/**
 * Repository interface for managing PanCard entities.
 */
public interface PanCardRepository {

    /**
     * Saves the given PanCard to the repository.
     *
     * @param panCard the PanCard to save
     */
    void save(PanCard panCard);

    /**
     * Finds a PanCard by its ID.
     *
     * @param id the ID of the PanCard
     * @return the PanCard with the given ID, or null if not found
     */
    PanCard findById(Long id);

    /**
     * Finds a PanCard by its PAN number.
     *
     * @param panNumber the PAN number of the PanCard
     * @return the PanCard with the given PAN number, or null if not found
     */
    PanCard findByPanNumber(String panNumber);

    /**
     * Deletes a PanCard by its ID.
     *
     * @param id the ID of the PanCard to delete
     */
    void delete(Long id);

    /**
     * Retrieves all PanCard entities from the repository.
     *
     * @return a list of all PanCard entities
     */
    List<PanCard> findAll();
}
