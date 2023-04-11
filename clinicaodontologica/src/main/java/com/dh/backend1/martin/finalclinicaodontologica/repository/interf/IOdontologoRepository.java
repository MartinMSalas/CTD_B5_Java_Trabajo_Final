package com.dh.backend1.martin.finalclinicaodontologica.repository.interf;

import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
