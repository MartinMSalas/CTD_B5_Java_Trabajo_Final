package com.dh.backend1.martin.finalclinicaodontologica.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Domicilios")
@Data
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private String pais;
    private Integer codigoPostal;

}
