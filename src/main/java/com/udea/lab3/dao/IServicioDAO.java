package com.udea.lab3.dao;

import com.udea.lab3.model.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioDAO extends CrudRepository<Servicio, Integer> {

}
