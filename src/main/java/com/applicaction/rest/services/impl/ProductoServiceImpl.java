package com.applicaction.rest.services.impl;

import com.applicaction.rest.entities.Producto;
import com.applicaction.rest.persistence.IProductoDao;
import com.applicaction.rest.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private IProductoDao productoDao;
    @Override
    public List<Producto> findAllProducts() {
        return productoDao.findAllProducts();
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productoDao.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDao.findById(id);
    }

    @Override
    public void save(Producto product) {
        productoDao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }
}
