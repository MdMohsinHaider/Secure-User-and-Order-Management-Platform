package com.mohsin.dao;

import com.mohsin.entity.PanCard;
import com.mohsin.repository.PanCardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PanCardDao implements PanCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(PanCard panCard) {
        if (panCard.getId() == null) {
            entityManager.persist(panCard);
        } else {
            entityManager.merge(panCard);
        }
    }

    @Override
    public PanCard findById(Long id) {
        return entityManager.find(PanCard.class, id);
    }

    @Override
    public PanCard findByPanNumber(String panNumber) {
        return entityManager.createQuery("SELECT p FROM PanCard p WHERE p.panNumber = :panNumber", PanCard.class)
                .setParameter("panNumber", panNumber)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        PanCard panCard = findById(id);
        if (panCard != null) {
            entityManager.remove(panCard);
        }
    }

    @Override
    public List<PanCard> findAll() {
        return entityManager.createQuery("SELECT p FROM PanCard p", PanCard.class)
                .getResultList();
    }
}
