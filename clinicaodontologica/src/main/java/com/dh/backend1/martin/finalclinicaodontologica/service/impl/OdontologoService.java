package com.dh.backend1.martin.finalclinicaodontologica.service.impl;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.interf.IOdontologoRepository;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Odontologo;
import com.dh.backend1.martin.finalclinicaodontologica.service.interf.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private ModelMapper modelMapper;
    
    private final IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    /*
    public OdontologoDto crearOdontologo(OdontologoDto odontologoDto) {
        Odontologo odontologo = odontologoRepository.save(modelMapper.map(odontologoDto, Odontologo.class));
        return modelMapper.map(odontologo, OdontologoDto.class);
    }
     */
    @Override
    public OdontologoDto save(OdontologoDto odontologoDto) {
        return this.saveOdontologo(odontologoDto);
    }
    @Override
    public OdontologoDto update(OdontologoDto odontologoDto) {
        return this.saveOdontologo(odontologoDto);
    }
    private OdontologoDto saveOdontologo(OdontologoDto odontologoDto) {
        Odontologo odontologo = odontologoRepository.save(modelMapper.map(odontologoDto, Odontologo.class));
        return modelMapper.map(odontologo, OdontologoDto.class);
    }
    @Override
    public Set<OdontologoDto> findAll() {
        Set<OdontologoDto> odontologoDtoList = new HashSet<>();

        odontologoRepository.findAll().forEach(odontologo -> odontologoDtoList.add(modelMapper.map(odontologo, OdontologoDto.class)));
        return odontologoDtoList;
    }

    @Override
    public OdontologoDto findById(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        return odontologo.map(value -> modelMapper.map(value, OdontologoDto.class)).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        odontologoRepository.deleteById(id);
    }


}
