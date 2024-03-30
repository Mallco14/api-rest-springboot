package com.applicaction.rest.services;

import com.applicaction.rest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakeService {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteById(Long id);
}
