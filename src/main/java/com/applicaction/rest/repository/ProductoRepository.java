package com.applicaction.rest.repository;

import com.applicaction.rest.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {

    @Query("SELECT p FROM Producto p WHERE p.precio >= ?1 AND p.precio <= ?2")
    List<Producto> findProductoByPrecioinRange(BigDecimal mixPrice, BigDecimal maxPrice);

    //Aplicando Query Methods
    List<Producto> findProductoByPrecioBetween(BigDecimal mixPrice, BigDecimal maxPrice);
}
