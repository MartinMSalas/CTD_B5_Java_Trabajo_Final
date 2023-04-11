package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    private OdontologoDto loadOdontologoDataSet(){
        OdontologoDto odontologoDto = new OdontologoDto("Martin", "Salas", 321);
        return odontologoService.save(odontologoDto);
    }
    @Test
    void save() {
        // Given
        OdontologoDto odontologoDtoExpected = loadOdontologoDataSet();
        // When
        OdontologoDto odontologoDtoObtained = odontologoService.save(odontologoDtoExpected);
        // Then
        assertEquals(odontologoDtoExpected.getMatricula(), odontologoDtoObtained.getMatricula());

    }

    @Test
    void update() {
        // Given
        OdontologoDto odontologoDtoExpected = loadOdontologoDataSet();
        // When
        OdontologoDto odontologoDtoObtained = odontologoService.update(odontologoDtoExpected);
        // Then
        assertEquals(odontologoDtoExpected.getMatricula(), odontologoDtoObtained.getMatricula());
    }

    @Test
    void findAll() {
        // Given
        OdontologoDto odontologoDtoExpected = loadOdontologoDataSet();
        // When
        Set<OdontologoDto> odontologoDtoSet = odontologoService.findAll();
        // Then
        assertTrue(odontologoDtoSet.size() > 0);
    }

    @Test
    void findById() {
        // Given
        OdontologoDto odontologoDtoExpected = loadOdontologoDataSet();
        // When
        OdontologoDto odontologoDtoObtained = odontologoService.findById(odontologoDtoExpected.getId());
        // Then
        assertEquals(odontologoDtoExpected.getMatricula(), odontologoDtoObtained.getMatricula());
    }

    @Test
    void deleteById() {
        //  Given
        OdontologoDto odontologoDtoExpected = loadOdontologoDataSet();
        // When
        odontologoService.deleteById(odontologoDtoExpected.getId());
        OdontologoDto odontologoDtoObtained = odontologoService.findById(odontologoDtoExpected.getId());
        // Then
        assertNull(odontologoDtoObtained);
    }
}