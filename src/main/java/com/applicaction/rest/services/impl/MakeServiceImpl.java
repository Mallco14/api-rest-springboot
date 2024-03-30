package com.applicaction.rest.services.impl;

import com.applicaction.rest.entities.Maker;
import com.applicaction.rest.persistence.IMakerDao;
import com.applicaction.rest.services.IMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeServiceImpl implements IMakeService {
    @Autowired
    private IMakerDao makerDao;
    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDao.deleteById(id);
    }
}
