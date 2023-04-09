package com.dh.backend1.martin.finalclinicaodontologica.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="Odontologos")
@Data
@NoArgsConstructor
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;



    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;



}
