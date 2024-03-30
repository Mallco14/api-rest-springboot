package com.applicaction.rest.persistence.impl;

import com.applicaction.rest.entities.Maker;
import com.applicaction.rest.persistence.IMakerDao;
import com.applicaction.rest.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MakerDaoImpl implements IMakerDao {
    @Autowired
    private MakeRepository makeRepository;
    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makeRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makeRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makeRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makeRepository.deleteById(id);
    }
}
