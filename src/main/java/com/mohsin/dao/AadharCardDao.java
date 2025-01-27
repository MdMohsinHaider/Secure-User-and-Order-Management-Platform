package com.mohsin.dao;

import com.mohsin.entity.AadharCard;
import com.mohsin.repository.AadharCardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class AadharCardDao implements AadharCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AadharCard aadharCard) {
        if (aadharCard.getId() == null) {
            entityManager.persist(aadharCard);
        } else {
            entityManager.merge(aadharCard);
        }
    }

    @Override
    public AadharCard findById(Long id) {
        return entityManager.find(AadharCard.class, id);
    }

    @Override
    public AadharCard findByAadharNumber(String aadharNumber) {
        return entityManager.createQuery("SELECT a FROM AadharCardEntity a WHERE a.aadharNumber = :aadharNumber", AadharCard.class)
                .setParameter("aadharNumber", aadharNumber)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        AadharCard aadharCard = findById(id);
        if (aadharCard != null) {
            entityManager.remove(aadharCard);
        }
    }

    @Override
    public List<AadharCard> findAll() {
        return entityManager.createQuery("SELECT a FROM AadharCardEntity a", AadharCard.class)
                .getResultList();
    }
}
