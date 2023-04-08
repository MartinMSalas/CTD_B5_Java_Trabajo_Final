package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PacienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private DomicilioDto domicilio;

    private LocalDate fechaAlta;

    public PacienteDto(String nombre, String apellido, Integer dni, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }
}
