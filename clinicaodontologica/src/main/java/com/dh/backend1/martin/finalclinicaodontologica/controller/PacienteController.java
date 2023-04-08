package com.dh.backend1.martin.finalclinicaodontologica.controller;


import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.time.LocalDate;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping("/crear")
    public ResponseEntity<PacienteDto> crearPaciente(@RequestBody PacienteDto pacienteDto) {

        if( pacienteDto.getApellido() == null || pacienteDto.getDni() == null)
            return ResponseEntity.badRequest().build();
        if( pacienteDto.getFechaAlta() == null){
            pacienteDto.setFechaAlta(LocalDate.now());
        }
        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDto));

    }

    @PostMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto pacienteDto) {

        if( pacienteDto.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(pacienteService.update(pacienteDto));

    }
    @GetMapping("/listar")
    public ResponseEntity<Iterable<PacienteDto>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.findAll());
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<PacienteDto> buscarPaciente(@PathVariable Integer id) {
        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(pacienteService.findById(id));
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<PacienteDto> borrarPaciente(@PathVariable Integer id) {

        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        if (pacienteService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        pacienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
