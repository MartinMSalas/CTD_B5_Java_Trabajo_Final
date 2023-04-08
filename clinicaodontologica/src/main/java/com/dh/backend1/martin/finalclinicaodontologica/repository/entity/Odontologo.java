package com.dh.backend1.martin.finalclinicaodontologica.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;
    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
