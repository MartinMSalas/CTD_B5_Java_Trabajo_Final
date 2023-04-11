package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;

import java.util.Set;

public interface IOdontologoService {
    OdontologoDto save(OdontologoDto odontologoDto);
    OdontologoDto findById(Integer id);
    void deleteById(Integer id);
    void update(OdontologoDto odontologoDto);
    Set<OdontologoDto> findAll();
}
