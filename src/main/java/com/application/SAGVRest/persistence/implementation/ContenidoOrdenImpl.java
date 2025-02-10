package com.application.SAGVRest.persistence.implementation;

import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.persistence.IContenidoOrdenDAO;
import com.application.SAGVRest.repository.ContenidoOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("contenidoOrdenPersistence")
@Qualifier("contenidoOrdenPersistence")
public class ContenidoOrdenImpl implements IContenidoOrdenDAO {

    @Autowired
    ContenidoOrdenRepository contenidoOrdenRepository;


    @Override
    public Optional<ContenidoOrden> findById(Long id) {
        return contenidoOrdenRepository.findById(id);
    }

    @Override
    public List<ContenidoOrden> findAll() {
        return (List<ContenidoOrden>) contenidoOrdenRepository.findAll();
    }

    @Override
    public void save(ContenidoOrden contenidoOrden) {
        contenidoOrdenRepository.save(contenidoOrden);
    }

    @Override
    public void deleteById(Long id) {
        contenidoOrdenRepository.deleteById(id);
    }
}
