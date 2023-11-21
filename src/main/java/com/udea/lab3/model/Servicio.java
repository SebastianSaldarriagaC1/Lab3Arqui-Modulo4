package com.udea.lab3.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Todos los detalles sobre los servicios de tranporte")
@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    @ApiModelProperty(notes = "Valor de ID generado por la base de datos")
    private Integer idServicio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    @ApiModelProperty(notes = "Usuario que pidio el servicio")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conductor")
    @ApiModelProperty(notes = "Conductor que atiende el servicio")
    private Conductor conductor;

    @Column(name = "ubicacion_origen")
    @ApiModelProperty(notes = "Ubicacion de recogida")
    private String ubicacionOrigen;

    @Column(name = "ubicacion_destino")
    @ApiModelProperty(notes = "Ubicacion de destino")
    private String ubicacionDestino;

    @Column(name = "fecha_inicio")
    @ApiModelProperty(notes = "Fecha de inicio del servicio (incluye hora)")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    @ApiModelProperty(notes = "Fecha de fin del servicio (incluye hora)")
    private LocalDateTime fechaFin;

    @Column(name = "estado")
    @ApiModelProperty(notes = "Estado del servcio. Ej: Pendiente, Completado, etc")
    private String estado;

    @Column(name = "detalles")
    @ApiModelProperty(notes = "Detalles adicionales del usuario al momento de hacer la peticion")
    private String detalles;

    @Column(name = "estado_pago")
    @ApiModelProperty(notes = "Estado del pago del servicio")
    private String estadoPago;

    @Column(name = "calificacion_conductor")
    @ApiModelProperty(notes = "Calificacion dada al conductor")
    @Min(value = 1, message = "La calificacion debe ser mayor o igual a 1")
    @Max(value = 5, message = "La calificacion debe ser menor o igual a 5")
    private Integer calificacionConductor;

    @Column(name = "calificacion_usuario")
    @ApiModelProperty(notes = "Calificacion dada al usuario")
    @Min(value = 1, message = "La calificacion debe ser mayor o igual a 1")
    @Max(value = 5, message = "La calificacion debe ser menor o igual a 5")
    private Integer calificacionUsuario;

    @Column(name = "costo")
    @ApiModelProperty(notes = "Costo total del servicio")
    private Double costo;

}
