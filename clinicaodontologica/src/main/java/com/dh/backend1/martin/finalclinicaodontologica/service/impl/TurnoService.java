package com.dh.backend1.martin.finalclinicaodontologica.service.impl;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.interf.ITurnoRepository;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Turno;
import com.dh.backend1.martin.finalclinicaodontologica.service.interf.ITurnoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ModelMapper modelMapper;

    private final ITurnoRepository turnoRepository;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    /*
    public TurnoDto crearTurno(TurnoDto turnoDtoExpected) {
        Turno turno1 = modelMapper.map(turnoDtoExpected, Turno.class);
        Turno turno = turnoRepository.save(turno1);
        return modelMapper.map(turno, TurnoDto.class);
    }
    */
    @Override
    public TurnoDto save(TurnoDto turnoDto) {
        return this.saveTurno(turnoDto);
    }
    @Override
    public TurnoDto update(TurnoDto turnoDtoExpected) {
        return saveTurno(turnoDtoExpected);
    }
    private TurnoDto saveTurno(TurnoDto turnoDtoExpected) {
        Turno turno = turnoRepository.save(modelMapper.map(turnoDtoExpected, Turno.class));
        return modelMapper.map(turno, TurnoDto.class);
    }
    @Override
    public TurnoDto findById(Integer id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);
        return turno.map(value -> this.modelMapper.map(value, TurnoDto.class)).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.turnoRepository.deleteById(id);
    }
    @Override
    public Set<TurnoDto> findAll() {
        Set<TurnoDto> turnoDtoList = new HashSet<>();
        this.turnoRepository.findAll().forEach(turno -> turnoDtoList.add(this.modelMapper.map(turno, TurnoDto.class)));
        return turnoDtoList;
    }

}
