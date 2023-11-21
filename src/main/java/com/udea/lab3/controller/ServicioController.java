package com.udea.lab3.controller;

import com.udea.lab3.exception.InvalidRating;
import com.udea.lab3.exception.ModelNotFoundException;
import com.udea.lab3.model.Servicio;
import com.udea.lab3.service.ServicioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
@CrossOrigin("*")
@Api(value = "Sistema de manejo de servicio de viaje", description = "Operaciones para los servicios")
public class ServicioController {
    @Autowired
    ServicioService servicioService;

    @ApiOperation(value = "Crear nuevo servicio")
    @PostMapping("/nuevo")
    public long save(@ApiParam(value = "Guarda un nuevo servicio en la tabla de la BD", required = true)
                     @RequestBody Servicio servicio) throws InvalidRating {
        if (servicio.getCalificacionConductor() > 5 || servicio.getCalificacionUsuario() > 5)
            throw new InvalidRating("La calificacion debe ser menor o igual a 5");

        servicioService.save(servicio);
        return servicio.getIdServicio();
    }

    @ApiOperation(value = "Ver la lista de todos los servicios", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("/historial")
    public Iterable<Servicio> listAllServicios(){
        return servicioService.findAll();
    }

    @ApiOperation(value = "Get Servicio by ID")
    @GetMapping("/ver/{id}")
    public Servicio listServicioById( @ApiParam(value = "Servicio ID from servicio object will retrive", required = true)
                                        @PathVariable("id") int id){
        Optional<Servicio> servicio= servicioService.findById(id);
        if(servicio.isPresent()){return servicio.get();
        }
        throw new ModelNotFoundException("ID de Servicio invalido");
    }

    @PutMapping
    public Servicio updateServicio(@RequestBody Servicio servicio){
        return servicioService.update(servicio);
    }

    @DeleteMapping("/{id}")
    public String deleteServicio(@PathVariable Integer id){
        return servicioService.delete(id);
    }
}
