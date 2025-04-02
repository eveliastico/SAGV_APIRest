package com.application.SAGVRest.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "numero_mesa")
    private int numMesa;

    @Column(name = "pago_pendiente")
    private boolean pagoPendiente = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContenidoOrden> listaContenidosOrdenes = new ArrayList<>();

    public Orden(int numMesa) {
        this.fechaHora = LocalDateTime.now();
        this.pagoPendiente = false;
        this.numMesa = numMesa;
    }

    public void agregarProducto(Producto producto, int cantidad, String notas) {
        ContenidoOrden contenidoOrden = new ContenidoOrden(this, producto, cantidad, notas);
        listaContenidosOrdenes.add(contenidoOrden);
    }
}
