package com.application.SAGVRest.Service;

import com.application.SAGVRest.entidades.Orden;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {

    Optional<Orden> findById(Long id);

    List<Orden> findAll();

    void save(Orden orden);

    void deleteById(Long id);

}
