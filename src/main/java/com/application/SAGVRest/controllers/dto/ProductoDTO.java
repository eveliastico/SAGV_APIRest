package com.application.SAGVRest.controllers.dto;

import com.application.SAGVRest.entidades.CategoriaProducto;
import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.entidades.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private CategoriaProducto categoriaProducto;

}
