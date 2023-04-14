package com.dh.backend1.martin.finalclinicaodontologica.modeldto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class TurnoDto {

    private Integer id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private LocalDateTime fecha;

    public TurnoDto(OdontologoDto odontologo, PacienteDto paciente, LocalDateTime fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public TurnoDto(OdontologoDto odontologo, PacienteDto paciente) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = LocalDateTime.now();
    }


}
