package com.dh.backend1.martin.finalclinicaodontologica.controller;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/crear")
    public ResponseEntity<OdontologoDto> crearOdontologo(@RequestBody OdontologoDto odontologoDto) {

        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDto));
    }


}
