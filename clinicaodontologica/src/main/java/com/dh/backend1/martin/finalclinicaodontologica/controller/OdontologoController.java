package com.dh.backend1.martin.finalclinicaodontologica.controller;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/crear")
    public ResponseEntity<OdontologoDto> crearOdontologo(@RequestBody OdontologoDto odontologoDto) {
        if (odontologoDto.getNombre() == null || odontologoDto.getApellido() == null || odontologoDto.getMatricula() == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDto));
    }
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo(@RequestBody OdontologoDto odontologoDto) {
        System.out.println(odontologoDto.getId());
        if (odontologoDto.getId() == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(odontologoService.update(odontologoDto));
    }
    @GetMapping("/listar")
    public ResponseEntity<Iterable<OdontologoDto>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.findAll());
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<OdontologoDto> buscarOdontologo(@PathVariable Integer id) {
        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(odontologoService.findById(id));
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<OdontologoDto> borrarOdontologo(@PathVariable Integer id) {
        if (id == null || id < 0)
            return ResponseEntity.badRequest().build();
        if (odontologoService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        odontologoService.delete(id);
        return ResponseEntity.ok().build();
    }



}
