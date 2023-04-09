package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.PacienteDto;
import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Turno;
import com.dh.backend1.martin.finalclinicaodontologica.repository.impl.TurnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private ModelMapper modelMapper;

    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    public TurnoDto crearTurno(TurnoDto turnoDtoExpected) {
        Turno turno1 = modelMapper.map(turnoDtoExpected, Turno.class);
        Turno turno = turnoRepository.save(turno1);
        return modelMapper.map(turno, TurnoDto.class);
    }

    public TurnoDto findById(Integer id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);
        return turno.map(value -> this.modelMapper.map(value, TurnoDto.class)).orElse(null);
    }

    public List<TurnoDto> findAll() {
        List<TurnoDto> turnoDtoList = new ArrayList<>();
        this.turnoRepository.findAll().forEach(turno -> turnoDtoList.add(this.modelMapper.map(turno, TurnoDto.class)));
        return turnoDtoList;
    }

    public TurnoDto update(TurnoDto turnoDtoExpected) {
        TurnoDto turnoDto = this.findById(turnoDtoExpected.getId());
        if (turnoDto != null) {
            turnoDto.setOdontologo(turnoDtoExpected.getOdontologo());
            turnoDto.setPaciente(turnoDtoExpected.getPaciente());
            turnoDto.setFecha(turnoDtoExpected.getFecha());
            turnoRepository.save(modelMapper.map(turnoDto, Turno.class));
            return modelMapper.map(turnoDto, TurnoDto.class);
        }
        return null;
    }
    public void delete(Integer id) {
        this.turnoRepository.deleteById(id);
    }
}
