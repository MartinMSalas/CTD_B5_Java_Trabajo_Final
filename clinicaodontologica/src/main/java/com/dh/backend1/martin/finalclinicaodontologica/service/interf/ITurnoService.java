package com.dh.backend1.martin.finalclinicaodontologica.service.interf;


import com.dh.backend1.martin.finalclinicaodontologica.modeldto.TurnoDto;

import java.util.Set;

public interface ITurnoService {

    TurnoDto save(TurnoDto turnoDto);
    TurnoDto findById(Integer id);
    void deleteById(Integer id);
    TurnoDto update(TurnoDto turnoDto);
    Set<TurnoDto> findAll();

}
