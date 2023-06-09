package com.dh.backend1.martin.finalclinicaodontologica.service.impl;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.interf.IPacienteRepository;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Paciente;
import com.dh.backend1.martin.finalclinicaodontologica.service.interf.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public PacienteDto save(PacienteDto pacienteDto) {
        return savePaciente(pacienteDto);

    }
    @Override
    public PacienteDto update(PacienteDto pacienteDto) {
        return savePaciente(pacienteDto);
    }
    private PacienteDto savePaciente(PacienteDto pacienteDto) {
        Paciente paciente = pacienteRepository.save(mapper.convertValue(pacienteDto, Paciente.class));
        return mapper.convertValue(paciente, PacienteDto.class);
    }
    @Override
    public PacienteDto findById(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(value -> mapper.convertValue(value, PacienteDto.class)).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDto> findAll() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        Set<PacienteDto> pacienteDtoSet = new HashSet<>();
        for(Paciente paciente: pacienteList)
            pacienteDtoSet.add(mapper.convertValue(paciente, PacienteDto.class));
        return pacienteDtoSet;
    }
}
