package com.udea.lab3.service;

import com.udea.lab3.dao.IServicioDAO;
import com.udea.lab3.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private IServicioDAO dao;

    public Servicio save(Servicio s){
        return dao.save(s);
    }

    public String delete(Integer id){
        dao.deleteById(id);
        return "Servicio eliminado";
    }

    public Iterable<Servicio> findAll(){
        return dao.findAll();
    }

    public Optional<Servicio> findById(Integer id){
        return dao.findById(id);
    }

    public Servicio update(Servicio s) {
        Servicio existingServicio = dao.findById(s.getIdServicio()).orElse(null);

        if (existingServicio != null) {
            existingServicio.setUsuario(s.getUsuario());
            existingServicio.setConductor(s.getConductor());
            existingServicio.setUbicacionOrigen(s.getUbicacionOrigen());
            existingServicio.setUbicacionDestino(s.getUbicacionDestino());
            existingServicio.setFechaInicio(s.getFechaInicio());
            existingServicio.setFechaFin(s.getFechaFin());
            existingServicio.setEstado(s.getEstado());
            existingServicio.setDetalles(s.getDetalles());
            existingServicio.setEstadoPago(s.getEstadoPago());
            existingServicio.setCalificacionConductor(s.getCalificacionConductor());
            existingServicio.setCalificacionUsuario(s.getCalificacionUsuario());
            existingServicio.setCosto(s.getCosto());

            return dao.save(existingServicio);
        } else {
            return null;
        }
    }

}
