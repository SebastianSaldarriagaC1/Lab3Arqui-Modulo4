package com.udea.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Todos los detalles sobre los conductores")
@Entity
public class Conductor {

    //Columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    @ApiModelProperty(notes = "El valor de ID generado por la base de datos")
    private Integer idConductor;

    @Column(name = "nombre")
    @ApiModelProperty(notes = "Nombre")
    private String nombre;

    @Column(name = "celular")
    @ApiModelProperty(notes = "Numero de celular")
    private String celular;

    @Column(name = "email")
    @ApiModelProperty(notes = "Direccion de correo electronico")
    private String email;

    @Column(name = "cedula")
    @ApiModelProperty(notes = "Numero de documento de identifiacion")
    private String cedula;

    @Column(name = "rol")
    @ApiModelProperty(notes = "Rol dentro de la aplicacion")
    private String rol;

    @Column(name = "nro_servicios")
    @ApiModelProperty(notes = "Numero de servicios atendidos como conductor")
        private Integer nroServicios;

    @Column(name = "vehiculo_placa")
    @ApiModelProperty(notes = "Placa del vehiculo que maneja")
    private String vehiculoPlaca;

    @Column(name = "vehiculo_marca")
    @ApiModelProperty(notes = "Marca del vehiculo que maneja")
    private String vehiculoMarca;

    @Column(name = "vehiculo_modelo")
    @ApiModelProperty(notes = "Modelo del vehiculo que maneja")
    private String vehiculoModelo;

    //Relaciones
    @JsonIgnore
    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Servicio> servicios;
}