package com.application.SAGVRest.Service.implementation;

import com.application.SAGVRest.Service.IProductoService;
import com.application.SAGVRest.entidades.CategoriaProducto;
import com.application.SAGVRest.entidades.Producto;
import com.application.SAGVRest.persistence.IProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoDAO productoDAO;

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal precioMin, BigDecimal precioMax) {
        return productoDAO.findByPriceInRange(precioMin, precioMax);
    }

    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    public List<Producto> findProductosByCategoriaProducto(CategoriaProducto categoriaProducto) {
        return productoDAO.findProductosByCategoriaProducto(categoriaProducto);
    }
}
