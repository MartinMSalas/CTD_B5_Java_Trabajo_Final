package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;

import java.util.Set;

public interface IPacienteService {
    void save(PacienteDto paciente);
    PacienteDto findById(Integer id);
    void deleteById(Integer id);
    void update(PacienteDto paciente);
    Set<PacienteDto> findAll();
}
