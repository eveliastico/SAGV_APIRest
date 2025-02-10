package com.application.SAGVRest.controllers.dto;

import com.application.SAGVRest.entidades.Orden;
import com.application.SAGVRest.entidades.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class ContenidoOrdenDTO {

    private Long id;
    private int cantidadProducto;
    private String notas;
    private Long idOrden;
    private Long idProducto;
}
