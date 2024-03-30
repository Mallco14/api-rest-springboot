package com.applicaction.rest.persistence;

import com.applicaction.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface IProductoDao {

    List<Producto> findAllProducts();
    List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    Optional<Producto> findById(Long id);
    void save(Producto product);
    void deleteById(Long id);
}
