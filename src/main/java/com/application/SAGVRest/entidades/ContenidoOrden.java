package com.application.SAGVRest.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "contenido_orden")
public class ContenidoOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_producto")
    private int cantidadProducto;

    private String notas;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public ContenidoOrden(Orden orden, Producto producto, int cantidadProducto, String notas){
        this.orden = orden;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.notas = notas;
    }

}
