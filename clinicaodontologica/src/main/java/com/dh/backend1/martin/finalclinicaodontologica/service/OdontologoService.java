package com.dh.backend1.martin.finalclinicaodontologica.service;

import com.dh.backend1.martin.finalclinicaodontologica.modeldto.OdontologoDto;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Odontologo;
import com.dh.backend1.martin.finalclinicaodontologica.repository.impl.OdontologoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private ModelMapper modelMapper;
    
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public OdontologoDto crearOdontologo(OdontologoDto odontologoDto) {
        OdontologoDto odontologoDto1;

        odontologoDto1 = modelMapper.map(odontologoRepository.save(modelMapper.map(odontologoDto, Odontologo.class)), OdontologoDto.class);
        return odontologoDto1;

    }

    public List<OdontologoDto> findAll() {
        List<OdontologoDto> odontologoDtoList = new ArrayList<>();
        odontologoRepository.findAll().forEach(odontologo -> odontologoDtoList.add(modelMapper.map(odontologo, OdontologoDto.class)));
        return odontologoDtoList;
    }

    public OdontologoDto findById(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        return odontologo.map(value -> modelMapper.map(value, OdontologoDto.class)).orElse(null);

    }

    public OdontologoDto update(OdontologoDto odontologoDtoExpected) {
        OdontologoDto odontologoDto = findById(odontologoDtoExpected.getId());
        if (odontologoDto != null) {
            int domicilioId = odontologoDto.getDomicilio().getId();
            odontologoDto.setNombre(odontologoDtoExpected.getNombre());
            odontologoDto.setApellido(odontologoDtoExpected.getApellido());
            odontologoDto.setMatricula(odontologoDtoExpected.getMatricula());
            odontologoDto.setDomicilio(odontologoDtoExpected.getDomicilio());
            odontologoDto.getDomicilio().setId(domicilioId);
            odontologoRepository.save(modelMapper.map(odontologoDto, Odontologo.class));
            return odontologoDto;
        }
        return null;
    }

    public void delete(Integer id) {
        odontologoRepository.deleteById(id);
    }
}
