package com.application.SAGVRest.persistence;


import com.application.SAGVRest.entidades.ContenidoOrden;

import java.util.List;
import java.util.Optional;

public interface IContenidoOrdenDAO {

    Optional<ContenidoOrden> findById(Long id);

    List<ContenidoOrden> findAll();

    void save(ContenidoOrden contenidoOrden);

    void deleteById(Long id);

}
