package com.dh.backend1.martin.finalclinicaodontologica.controller;


import com.dh.backend1.martin.finalclinicaodontologica.exceptions.PacienteSinDomicilioException;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping("/crear")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto pacienteDto)  throws Exception {

        if( pacienteDto.getApellido() == null || pacienteDto.getDni() == null)
            return ResponseEntity.badRequest().build();
        if (pacienteDto.getDomicilio() == null)
            throw new PacienteSinDomicilioException("El domicilio del paciente no puede ser nulo");

        if( pacienteDto.getFechaAlta() == null){
            pacienteDto.setFechaAlta(LocalDate.now());
        }
        //return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(pacienteService.save(pacienteDto));

    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto pacienteDto) {

        if( pacienteDto.getId() == null || pacienteDto.getApellido() == null || pacienteDto.getDni() == null)
            return ResponseEntity.badRequest().build();
        if( pacienteDto.getFechaAlta() == null){
            pacienteDto.setFechaAlta(LocalDate.now());
        }
        return ResponseEntity.ok(pacienteService.update(pacienteDto));
        //return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<PacienteDto> buscarPaciente(@PathVariable Integer id) {
        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        PacienteDto pacienteDto = pacienteService.findById(id);
        if (pacienteDto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pacienteService.findById(id));
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<PacienteDto>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.findAll());
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<PacienteDto> borrarPaciente(@PathVariable Integer id) {

        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        if (pacienteService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        pacienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
