package com.application.SAGVRest.repository;

import com.application.SAGVRest.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    //JPQL
    @Query("SELECT p FROM Producto p WHERE p.precio >= ?1 AND p.precio <= ?2")
    //Otra forma de hacer lo mismo es usando el operador BETWEEN
    //@Query("SELECT p FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")
    List<Producto> findProductoByPrecioInRange(BigDecimal precioMin, BigDecimal precioMax);

    List<Producto> findProductosByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

}
