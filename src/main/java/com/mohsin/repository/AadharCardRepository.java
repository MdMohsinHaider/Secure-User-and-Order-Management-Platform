package com.mohsin.repository;

import com.mohsin.entity.AadharCard;

import java.util.List;

public interface AadharCardRepository {
    void save(AadharCard aadharCard);
    AadharCard findById(Long id);
    AadharCard findByAadharNumber(String aadharNumber);
    void delete(Long id);
    List<AadharCard> findAll();
}
