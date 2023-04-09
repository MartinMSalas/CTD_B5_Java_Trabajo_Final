package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class OdontologoDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    //private List<TurnoDto> turnos;




    public OdontologoDto(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;

    }



}
