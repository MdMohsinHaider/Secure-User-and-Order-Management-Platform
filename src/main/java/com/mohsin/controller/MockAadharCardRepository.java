package com.mohsin.controller;

import com.mohsin.entity.AadharCard;
import com.mohsin.repository.AadharCardRepository;

import java.util.ArrayList;
import java.util.List;

class MockAadharCardRepository implements AadharCardRepository {
    private List<AadharCard> aadharCards = new ArrayList<>();

    @Override
    public void save(AadharCard aadharCard) {
        aadharCards.add(aadharCard);
    }

    @Override
    public AadharCard findById(Long id) {
        return aadharCards.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public AadharCard findByAadharNumber(String aadharNumber) {
        return aadharCards.stream().filter(a -> a.getAadharNumber().equals(aadharNumber)).findFirst().orElse(null);
    }

    @Override
    public void delete(Long id) {
        aadharCards.removeIf(a -> a.getId().equals(id));
    }

    @Override
    public List<AadharCard> findAll() {
        return aadharCards;
    }
}
