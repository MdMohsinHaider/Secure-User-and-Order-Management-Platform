package com.mohsin.controller;

import com.mohsin.entity.PanCard;
import com.mohsin.repository.PanCardRepository;

import java.util.ArrayList;
import java.util.List;

class MockPanCardRepository implements PanCardRepository {
    private List<PanCard> panCards = new ArrayList<>();

    @Override
    public void save(PanCard panCard) {
        panCards.add(panCard);
    }

    @Override
    public PanCard findById(Long id) {
        return panCards.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public PanCard findByPanNumber(String panNumber) {
        return panCards.stream().filter(p -> p.getPanNumber().equals(panNumber)).findFirst().orElse(null);
    }

    @Override
    public void delete(Long id) {
        panCards.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<PanCard> findAll() {
        return panCards;
    }
}
