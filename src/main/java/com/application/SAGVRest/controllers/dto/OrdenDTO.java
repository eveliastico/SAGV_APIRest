package com.application.SAGVRest.controllers.dto;

import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.entidades.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private int numMesa;
    private List<ContenidoOrden> listaContenidosOrdenes = new ArrayList<>();
}
