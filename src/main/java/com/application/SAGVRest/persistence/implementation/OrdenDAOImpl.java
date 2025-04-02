package com.application.SAGVRest.persistence.implementation;

import com.application.SAGVRest.entidades.Orden;
import com.application.SAGVRest.persistence.IOrdenDAO;
import com.application.SAGVRest.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class OrdenDAOImpl implements IOrdenDAO {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    @Override
    public List<Orden> findAll() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    public void save(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public List<Orden> findOrdenByFechaHoraBetween(LocalDateTime fechaMin, LocalDateTime fechaMax) {
        return (List<Orden>) ordenRepository.findOrdenByFechaHoraBetween(fechaMin, fechaMax);
    }

    @Override
    public List<Orden> findOrdenByNumMesa(int numMesa) {
        return (List<Orden>) ordenRepository.findOrdenByNumMesa(numMesa);
    }


}
