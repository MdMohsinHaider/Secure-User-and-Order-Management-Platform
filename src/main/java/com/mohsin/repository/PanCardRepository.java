package com.mohsin.repository;


import com.mohsin.entity.PanCard;

import java.util.List;

public interface PanCardRepository {
    void save(PanCard panCardRepository);
    PanCard findById(Long id);
    PanCard findByPanNumber(String panNumber);
    void delete(Long id);
    List<PanCard> findAll();


}
