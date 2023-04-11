package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

//----------------------
import org.junit.jupiter.api.Test;

//--------------------


@SpringBootTest
class PacienteServiceTestDemo {
    @Autowired
    private IPacienteService pacienteService;
    @Test
    public void testCrearPaciente() {
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setNombre("Martin");
        pacienteDto.setApellido("Salas");
        pacienteService.save(pacienteDto);

        PacienteDto pacienteDto1 = pacienteService.findById(1);

        assertTrue(pacienteDto1!=null);
    }

}