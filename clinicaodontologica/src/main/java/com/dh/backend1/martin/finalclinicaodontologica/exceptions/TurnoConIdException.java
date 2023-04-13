package com.dh.backend1.martin.finalclinicaodontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurnoConIdException extends Exception{

            public TurnoConIdException(String mensaje) {
                //
                super(mensaje);

            }
}
