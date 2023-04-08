package com.dh.backend1.martin.finalclinicaodontologica;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.DomicilioDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.service.OdontologoService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService ;



    private PacienteDto cargarOdontoloSet() {
        //DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        DomicilioDto domicilioDto = new DomicilioDto("siempreViva",1234);
        PacienteDto pacienteDtoExpected = new PacienteDto("Santiago", "Paz", 3455647,domicilioDto);
        PacienteDto pacienteDtoObtained  = this.pacienteService.crearPaciente(pacienteDtoExpected);

        return pacienteDtoObtained;
    }
}
