package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    private PacienteDto loadPacienteDataSet(){
        DomicilioDto domicilioDto = new DomicilioDto("Calle falsa",123);
        PacienteDto pacienteDtoExpected = new PacienteDto("Martin", "Salas",666,domicilioDto);
        return pacienteService.save(pacienteDtoExpected);
    }

    @Test
    void testSavePaciente() {
        // Given
        PacienteDto pacienteDtoExpected = loadPacienteDataSet();
        // When
        PacienteDto pacienteDtoObtained = pacienteService.save(pacienteDtoExpected);
        // Then
        assertEquals(pacienteDtoExpected.getDni(), pacienteDtoObtained.getDni());

    }

    @Test
    void testUpdatePaciente() {
        // Given
        PacienteDto pacienteDtoExpected = loadPacienteDataSet();
        // When
        PacienteDto pacienteDtoObtained = pacienteService.update(pacienteDtoExpected);
        // Then
        assertEquals(pacienteDtoExpected.getDni(), pacienteDtoObtained.getDni());
    }

    @Test
    void testFindByIdPaciente() {
        // Given
        PacienteDto pacienteDtoExpected = loadPacienteDataSet();
        // When
        PacienteDto pacienteDtoObtained = pacienteService.findById(pacienteDtoExpected.getId());
        // Then
        assertEquals(pacienteDtoExpected.getDni(), pacienteDtoObtained.getDni());
    }

    @Test
    void testDeleteByIdPaciente() {
        // Given
        PacienteDto pacienteDtoExpected = loadPacienteDataSet();
        // When
        pacienteService.deleteById(pacienteDtoExpected.getId());
        PacienteDto pacienteDtoObtained = pacienteService.findById(pacienteDtoExpected.getId());

        // Then
        assertNull(pacienteDtoObtained);
    }

    @Test
    void testFindAll() {
        // Given
        PacienteDto pacienteDtoExpected = loadPacienteDataSet();
        // When
        Set<PacienteDto> pacienteDtoSet = pacienteService.findAll();
        // Then
        assertTrue(pacienteDtoSet.size()>0);
    }
}