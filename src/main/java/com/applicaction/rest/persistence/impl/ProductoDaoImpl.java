package com.applicaction.rest.persistence.impl;

import com.applicaction.rest.entities.Producto;
import com.applicaction.rest.persistence.IProductoDao;
import com.applicaction.rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDaoImpl implements IProductoDao {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAllProducts() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {

        return productoRepository.findProductoByPrecioinRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void save(Producto product) {
            productoRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
