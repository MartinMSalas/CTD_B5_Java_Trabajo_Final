package com.dh.backend1.martin.finalclinicaodontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurnoConFechaPasadaException extends Exception{

            public TurnoConFechaPasadaException(String mensaje) {
                //
                super(mensaje);

            }
}
