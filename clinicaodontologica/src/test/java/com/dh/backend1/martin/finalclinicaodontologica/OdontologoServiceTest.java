package com.dh.backend1.martin.finalclinicaodontologica;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService ;



    private OdontologoDto cargarOdontoloSet() {
        //DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        OdontologoDto odontologoDtoExpected = new OdontologoDto("Santiago", "Paz", 3455647,domicilioDto);
        OdontologoDto odontologoDtoObtained  = this.odontologoService.crearOdontologo(odontologoDtoExpected);
        //this.odontologoService.crearOdontologo(new OdontologoDto("Santiago", "Paz", 3455647,domicilioDto));
        return odontologoDtoExpected;
    }

    @Test
    public void testCrearOdontologo() {
        // Given

        OdontologoDto odontologoDtoExpected = cargarOdontoloSet();

        // When
        OdontologoDto odontologoDtoObtained  = this.odontologoService.crearOdontologo(odontologoDtoExpected);
        // Then
        Assert.assertEquals(odontologoDtoObtained.getMatricula(), odontologoDtoExpected.getMatricula());
    }
    @Test
    public void testFindAll(){
        // Given
        this.cargarOdontoloSet();

        // When
        List<OdontologoDto> odontologoDtoListObtained = this.odontologoService.findAll();
        // Then
        Assert.assertTrue(odontologoDtoListObtained.size() > 0);

    }
}
