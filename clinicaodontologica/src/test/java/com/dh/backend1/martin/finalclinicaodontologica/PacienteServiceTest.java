package com.dh.backend1.martin.finalclinicaodontologica;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService ;



    private PacienteDto cargarPacienteSet() {
        //DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        PacienteDto pacienteDtoExpected = new PacienteDto("Santiago", "Paz", 3455647,domicilioDto);
        return this.pacienteService.crearPaciente(pacienteDtoExpected);
    }

    @Test
    public void testCrearPaciente() {
        // Given

        PacienteDto pacienteDtoExpected = cargarPacienteSet();

        // When
        PacienteDto pacienteDtoObtained  = this.pacienteService.crearPaciente(pacienteDtoExpected);
        // Then
        Assert.assertEquals(pacienteDtoObtained.getDni(), pacienteDtoExpected.getDni());
    }

    @Test
    public void testFindAll(){
        // Given
        this.cargarPacienteSet();
        // When
        List<PacienteDto> pacienteDtoListObtained = this.pacienteService.findAll();
        // Then
        Assert.assertTrue(pacienteDtoListObtained.size() > 0);
    }

    @Test
    public void testFindById(){
        // Given
        PacienteDto pacienteDtoExpected = cargarPacienteSet();
        // When
        PacienteDto pacienteDtoObtained = this.pacienteService.findById(pacienteDtoExpected.getId());
        // Then
        Assert.assertEquals(pacienteDtoObtained.getId(), pacienteDtoExpected.getId());
    }

    @Test
    public void testUpdate(){
        // Given
        PacienteDto pacienteDtoExpected = cargarPacienteSet();
        // When
        PacienteDto pacienteDtoObtained = this.pacienteService.update(pacienteDtoExpected);
        // Then
        Assert.assertEquals(pacienteDtoObtained.getId(), pacienteDtoExpected.getId());
    }

    @Test
    public void testDelete(){
        // Given
        PacienteDto pacienteDtoExpected = cargarPacienteSet();
        // When
        this.pacienteService.delete(pacienteDtoExpected.getId());
        // Then
        Assert.assertNull(this.pacienteService.findById(pacienteDtoExpected.getId()));
    }
}
