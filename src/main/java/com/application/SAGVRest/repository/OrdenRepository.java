package com.application.SAGVRest.repository;

import com.application.SAGVRest.entidades.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long> {

    /**
     * Devuelve una lista con las ordenes asociadas a una mesa.
     * @param numMesa
     * @return List<Orden>
     */
    List<Orden> findOrdenByNumMesa(int numMesa);

    /**
     * Devuelve una lista con las ordenes entre un rango de fechas.
     * @param fechaMin
     * @param fechaMax
     * @return List<Orden>
     */
    List<Orden> findOrdenByFechaHoraBetween(LocalDateTime fechaMin, LocalDateTime fechaMax);
}
