package com.dh.backend1.martin.finalclinicaodontologica.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaAlta;
    /*
    private Integer telefono;
    private String email;
    private String obraSocial;
    private Integer numeroAfiliado;
    */

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    /*
    public Paciente(String nombre, String apellido, Integer dni, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }
    */

}
