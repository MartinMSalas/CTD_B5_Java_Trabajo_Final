package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IOdontologoService odontologoService;

    private TurnoDto loadTurnoDataSet(){
        DomicilioDto domicilioDto = new DomicilioDto("Calle falsa",123);
        PacienteDto pacienteDto = pacienteService.save(new PacienteDto("Martin", "Salas",666,domicilioDto));
        OdontologoDto odontologoDto = odontologoService.save(new OdontologoDto("Martin", "Salas", 321));
        TurnoDto turnoDto = new TurnoDto(odontologoDto,pacienteDto);
        return turnoService.save(turnoDto);
    }
    @Test
    void save() {
        //  Given
        TurnoDto turnoDtoExpected = loadTurnoDataSet();
        // When
        TurnoDto turnoDtoObtained = turnoService.save(turnoDtoExpected);
        // Then
        assertEquals(turnoDtoExpected.getId(), turnoDtoObtained.getId());
    }

    @Test
    void update() {
        // Given
        TurnoDto turnoDtoExpected = loadTurnoDataSet();
        // When
        TurnoDto turnoDtoObtained = turnoService.update(turnoDtoExpected);
        // Then
        assertEquals(turnoDtoExpected.getId(), turnoDtoObtained.getId());
    }

    @Test
    void findById() {
        // Given
        TurnoDto turnoDtoExpected = loadTurnoDataSet();
        // When
        TurnoDto turnoDtoObtained = turnoService.findById(turnoDtoExpected.getId());
        // Then
        assertEquals(turnoDtoExpected.getId(), turnoDtoObtained.getId());
    }

    @Test
    void deleteById() {
        // Given
        TurnoDto turnoDtoExpected = loadTurnoDataSet();
        // When
        turnoService.deleteById(turnoDtoExpected.getId());
        // Then
        assertNull(turnoService.findById(turnoDtoExpected.getId()));
    }

    @Test
    void findAll() {
        // Given
        TurnoDto turnoDtoExpected = loadTurnoDataSet();
        // When
        Set<TurnoDto> turnoDtoSet = turnoService.findAll();
        // Then
        assertTrue(turnoDtoSet.size()>0);
    }
}