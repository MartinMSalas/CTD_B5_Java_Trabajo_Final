package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDto {
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private String pais;
    private Integer codigoPostal;

    public DomicilioDto(String calle, Integer numero) {
        this.calle = calle;
        this.numero = numero;
    }
}
