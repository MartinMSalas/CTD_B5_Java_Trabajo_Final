package com.dh.backend1.martin.finalclinicaodontologica.service.interf;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;

import java.util.Set;

public interface IPacienteService {
    PacienteDto save(PacienteDto pacienteDto);
    PacienteDto findById(Integer id);
    void deleteById(Integer id);
    PacienteDto update(PacienteDto pacienteDto);
    Set<PacienteDto> findAll();
}
