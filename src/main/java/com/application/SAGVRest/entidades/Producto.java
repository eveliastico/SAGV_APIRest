package com.application.SAGVRest.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(precision = 10, scale = 2)
    private BigDecimal precio;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_producto", nullable = false)
    private CategoriaProducto categoriaProducto;

}
