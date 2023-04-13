package com.dh.backend1.martin.finalclinicaodontologica.repository.interf;

import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.auth.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional()
public interface IUserRepository  extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByEmail(String email);

}
