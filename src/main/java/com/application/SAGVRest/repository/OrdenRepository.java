package com.application.SAGVRest.repository;

import com.application.SAGVRest.entidades.Orden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long> {

}
