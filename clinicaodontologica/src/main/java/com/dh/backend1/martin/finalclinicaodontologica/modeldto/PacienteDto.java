package com.dh.backend1.martin.finalclinicaodontologica.modeldto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class PacienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private DomicilioDto domicilio;

    private LocalDate fechaAlta;

    //private List<TurnoDto> turnos;

    public PacienteDto(String nombre, String apellido, Integer dni, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = LocalDate.now();
    }
    /*
    public PacienteDto(String nombre, String apellido, Integer dni, DomicilioDto domicilio, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
    }
     */

    @Override
    public String toString() {
        return "PacienteDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", domicilio=" + domicilio +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacienteDto that = (PacienteDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(nombre, that.nombre)) return false;
        if (!Objects.equals(apellido, that.apellido)) return false;
        if (!Objects.equals(dni, that.dni)) return false;
        if (!Objects.equals(domicilio, that.domicilio)) return false;
        return Objects.equals(fechaAlta, that.fechaAlta);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        return result;
    }
}
