package com.application.SAGVRest.persistence.implementation;

import com.application.SAGVRest.entidades.Producto;
import com.application.SAGVRest.persistence.IProductoDAO;
import com.application.SAGVRest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    ProductoRepository productoRepository;
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal precioMin, BigDecimal precioMax) {
        return productoRepository.findProductoByPrecioInRange(precioMin, precioMax);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
