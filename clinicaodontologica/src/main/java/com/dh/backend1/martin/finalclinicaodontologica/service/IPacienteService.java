package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;

import java.util.Set;

public interface IPacienteService {
    void save(PacienteDto pacienteDto);
    PacienteDto findById(Integer id);
    void deleteById(Integer id);
    void update(PacienteDto pacienteDto);
    Set<PacienteDto> findAll();
}
