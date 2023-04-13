package com.dh.backend1.martin.finalclinicaodontologica.controller;

import com.dh.backend1.martin.finalclinicaodontologica.exceptions.TurnoConFechaPasadaException;
import com.dh.backend1.martin.finalclinicaodontologica.exceptions.TurnoConIdException;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<TurnoDto> crearTurno(@RequestBody TurnoDto turnoDto) throws Exception {

        if( turnoDto.getOdontologo() == null || turnoDto.getPaciente() == null)
            return ResponseEntity.badRequest().build();
        if (turnoDto.getId()!= null)
            throw new TurnoConIdException("El id del turno debe ser nulo");
        if( turnoDto.getFecha() == null){
            turnoDto.setFecha(LocalDateTime.now());
        } else if (turnoDto.getFecha().isBefore(LocalDateTime.now())) {
            throw new TurnoConFechaPasadaException("La fecha del turno no puede ser anterior a la fecha actual");
        }

        if (turnoDto.getPaciente().getFechaAlta() == null){
            turnoDto.getPaciente().setFechaAlta(LocalDate.now());
        }
        return ResponseEntity.ok(turnoService.save(turnoDto));

    }

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDto> actualizarTurno(@RequestBody TurnoDto turnoDto) {

        if( turnoDto.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(turnoService.update(turnoDto));

    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<TurnoDto>> listarTurno() {
        return ResponseEntity.ok(turnoService.findAll());
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TurnoDto> buscarTurno(@PathVariable Integer id) {
        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        TurnoDto turnoDto = turnoService.findById(id);
        if (turnoDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turnoService.findById(id));
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<TurnoDto> borrarTurno(@PathVariable Integer id) {

        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        if (turnoService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        turnoService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
