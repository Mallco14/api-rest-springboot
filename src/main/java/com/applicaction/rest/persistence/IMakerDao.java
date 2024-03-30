package com.applicaction.rest.persistence;

import com.applicaction.rest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDao {
    //implementando los metoddos a usar
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteById(Long id);
}
