package com.application.SAGVRest.controllers.dto;

import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.entidades.Producto;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    // Aquí usamos @JsonFormat para definir el formato en el que se serializa y deserializa la fecha.
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaHora;
    private int numMesa;
    private boolean pagoPendiente = false;
    private List<ContenidoOrden> listaContenidosOrdenes = new ArrayList<>();
}
