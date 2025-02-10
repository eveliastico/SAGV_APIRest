package com.application.SAGVRest.persistence;

import com.application.SAGVRest.entidades.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoDAO {

    Optional<Producto> findById(Long id);

    List<Producto> findAll();

    List<Producto> findByPriceInRange(BigDecimal precioMin, BigDecimal precioMax);

    void save(Producto producto);

    void deleteById(Long id);




}
