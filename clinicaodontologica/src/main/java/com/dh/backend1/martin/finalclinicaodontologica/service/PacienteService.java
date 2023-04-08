package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Paciente;
import com.dh.backend1.martin.finalclinicaodontologica.repository.impl.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private ModelMapper modelMapper;

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    public PacienteDto crearPaciente(PacienteDto pacienteDtoExpected) {
       Paciente paciente = this.pacienteRepository.save(this.modelMapper.map(pacienteDtoExpected, Paciente.class));
       return this.modelMapper.map(paciente, PacienteDto.class);

    }

    public List<PacienteDto> findAll() {
        List<PacienteDto> pacienteDtoList = new ArrayList<>();
        this.pacienteRepository.findAll().forEach(paciente -> pacienteDtoList.add(this.modelMapper.map(paciente, PacienteDto.class)));
        return pacienteDtoList;

    }

    public PacienteDto findById(Integer id) {
        Optional<Paciente> paciente = this.pacienteRepository.findById(id);
        return paciente.map(value -> this.modelMapper.map(value, PacienteDto.class)).orElse(null);
    }

    public PacienteDto update(PacienteDto pacienteDtoExpected) {
        PacienteDto pacienteDto = this.findById(pacienteDtoExpected.getId());
        if (pacienteDto != null) {
            int idDomicilio = pacienteDto.getDomicilio().getId();
            pacienteDto.setNombre(pacienteDtoExpected.getNombre());
            pacienteDto.setApellido(pacienteDtoExpected.getApellido());
            pacienteDto.setDni(pacienteDtoExpected.getDni());
            pacienteDto.setDomicilio(pacienteDtoExpected.getDomicilio());
            pacienteDto.getDomicilio().setId(idDomicilio);
            this.pacienteRepository.save(modelMapper.map(pacienteDto,Paciente.class));
            return this.modelMapper.map(pacienteDto, PacienteDto.class);
        }
        return null;
    }

    public void delete(Integer id) {
        this.pacienteRepository.deleteById(id);
    }
}
