package com.dh.backend1.martin.finalclinicaodontologica.config.security;

import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.auth.AppUser;
import com.dh.backend1.martin.finalclinicaodontologica.repository.entity.auth.AppUserarioRoles;
import com.dh.backend1.martin.finalclinicaodontologica.repository.interf.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("passwordtest");

        userRepository.save(new AppUser("Martin", "martin", "martin@digital.com", password, AppUserarioRoles.ADMIN));
        userRepository.save(new AppUser("Martin2", "martin2", "martin2@digital.com", password2 , AppUserarioRoles.USER));

    }
}
