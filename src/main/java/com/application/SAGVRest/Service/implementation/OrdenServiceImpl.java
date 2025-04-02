package com.application.SAGVRest.Service.implementation;

import com.application.SAGVRest.Service.IOrdenService;
import com.application.SAGVRest.entidades.Orden;
import com.application.SAGVRest.persistence.IOrdenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements IOrdenService {

    @Autowired
    IOrdenDAO ordenDAO;

    @Override
    public Optional<Orden> findById(Long id) {
        return ordenDAO.findById(id);
    }

    @Override
    public List<Orden> findAll() {
        return ordenDAO.findAll();
    }

    @Override
    public void save(Orden orden) {
        ordenDAO.save(orden);
    }

    @Override
    public void deleteById(Long id) {
        ordenDAO.deleteById(id);
    }

    @Override
    public List<Orden> findOrdenByFechaHoraBetween(LocalDateTime fechaMin, LocalDateTime fechaMax) {
        return ordenDAO.findOrdenByFechaHoraBetween(fechaMin, fechaMax);
    }

    @Override
    public List<Orden> findOrdenByNumMesa(int numMesa) {
        return ordenDAO.findOrdenByNumMesa(numMesa);
    }


}
