package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.IPacienteRepository;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void save(PacienteDto pacienteDto) {
        savePaciente(pacienteDto);

    }

    @Override
    public PacienteDto findById(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDto pacienteDto = null;

        if(paciente.isPresent())
            pacienteDto = mapper.convertValue(paciente, PacienteDto.class);
        return pacienteDto;
    }

    @Override
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
    private void savePaciente(PacienteDto pacienteDto) {
        Paciente newPaciente = mapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(newPaciente);
    }
    @Override
    public void update(PacienteDto pacienteDto) {
        savePaciente(pacienteDto);
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
