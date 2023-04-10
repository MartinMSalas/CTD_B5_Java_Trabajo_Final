package com.dh.backend1.martin.finalclinicaodontologica;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.OdontologoService;
import com.dh.backend1.martin.finalclinicaodontologica.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService ;
    @Autowired
    private PacienteService pacienteService ;

    private TurnoDto cargarTurnoSet() {
        //DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        // System.out.println(LocalDate.now());  ---> 2023-04-08
        DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);


        OdontologoDto odontologoDto = odontologoService.crearOdontologo(new OdontologoDto("Santiago", "Paz", 3455647));

        PacienteDto pacienteDto = pacienteService.crearPaciente(new PacienteDto("Santiago", "Paz", 3455647,domicilioDto));
        //TurnoDto turnoDtoExpected = new TurnoDto(odontologoDto, pacienteDto, LocalDateTime.now());

        return this.turnoService.crearTurno(new TurnoDto(odontologoDto, pacienteDto, LocalDateTime.now()));
    }

    @Test
    public void testCrearTurno() {
        // Given
        TurnoDto turnoDtoExpected = cargarTurnoSet();
        // When
        TurnoDto turnoDtoObtained  = this.turnoService.crearTurno(turnoDtoExpected);
        // Then
        Assert.assertEquals(turnoDtoObtained, turnoDtoExpected);
    }
    @Test
    public void testFindAll(){
        // Given
        this.cargarTurnoSet();
        // When
        List<TurnoDto> turnoDtoListObtained = this.turnoService.findAll();
        // Then
        Assert.assertTrue(turnoDtoListObtained.size() > 0);
    }
    @Test
    public void testFindById(){
        // Given
        TurnoDto turnoDtoExpected = cargarTurnoSet();
        // When
        TurnoDto turnoDtoObtained = this.turnoService.findById(turnoDtoExpected.getId());
        // Then
        Assert.assertEquals(turnoDtoObtained.getId(), turnoDtoExpected.getId());
    }

    @Test
    public void testUpdate(){
        // Given
        TurnoDto turnoDtoExpected = cargarTurnoSet();
        // When
        TurnoDto turnoDtoObtained = this.turnoService.update(turnoDtoExpected);
        // Then
        Assert.assertEquals(turnoDtoObtained.getId(), turnoDtoExpected.getId());
    }

    @Test
    public void testDelete(){
        // Given
        TurnoDto turnoDtoExpected = cargarTurnoSet();
        // When
        this.turnoService.delete(turnoDtoExpected.getId());
        // Then
        Assert.assertNull(this.turnoService.findById(turnoDtoExpected.getId()));
    }

}
