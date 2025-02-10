package com.application.SAGVRest.Service.implementation;

import com.application.SAGVRest.Service.IContenidoOrdenService;
import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.persistence.IContenidoOrdenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("contenidoOrdenService")
@Qualifier("contenidoOrdenService")
public class ContenidoOrdenImpl implements IContenidoOrdenService {

    @Autowired
    IContenidoOrdenDAO contenidoOrdenDAO;

    @Override
    public Optional<ContenidoOrden> findById(Long id) {
        return contenidoOrdenDAO.findById(id);
    }

    @Override
    public List<ContenidoOrden> findAll() {
        return contenidoOrdenDAO.findAll();
    }

    @Override
    public void save(ContenidoOrden contenidoOrden) {
        contenidoOrdenDAO.save(contenidoOrden);
    }

    @Override
    public void deleteById(Long id) {
        contenidoOrdenDAO.deleteById(id);
    }
}
