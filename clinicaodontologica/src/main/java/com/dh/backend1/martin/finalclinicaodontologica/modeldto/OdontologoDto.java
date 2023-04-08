package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OdontologoDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private DomicilioDto domicilio;

    public OdontologoDto(Integer matricula, DomicilioDto domicilio) {
        this.matricula = matricula;
        this.domicilio = domicilio;
    }

    public OdontologoDto(String nombre, String apellido, Integer matricula, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.domicilio = domicilio;
    }
}
