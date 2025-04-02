package com.application.SAGVRest.persistence;

import com.application.SAGVRest.entidades.Orden;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrdenDAO {
    Optional<Orden> findById(Long id);

    List<Orden> findAll();

    void save(Orden orden);

    void deleteById(Long id);

    List<Orden> findOrdenByFechaHoraBetween(LocalDateTime fechaMin, LocalDateTime fechaMax);

    List<Orden> findOrdenByNumMesa(int numMesa);

}
