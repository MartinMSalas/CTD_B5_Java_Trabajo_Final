package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TurnoDto turnoDto = (TurnoDto) o;

        if (!Objects.equals(id, turnoDto.id)) return false;
        if (!Objects.equals(odontologo, turnoDto.odontologo)) return false;
        if (!Objects.equals(paciente, turnoDto.paciente)) return false;
        return Objects.equals(fecha, turnoDto.fecha);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (odontologo != null ? odontologo.hashCode() : 0);
        result = 31 * result + (paciente != null ? paciente.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
