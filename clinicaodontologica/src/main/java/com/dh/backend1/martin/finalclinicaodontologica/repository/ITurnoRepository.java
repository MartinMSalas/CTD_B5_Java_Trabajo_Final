package com.dh.backend1.martin.finalclinicaodontologica.repository;

import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
