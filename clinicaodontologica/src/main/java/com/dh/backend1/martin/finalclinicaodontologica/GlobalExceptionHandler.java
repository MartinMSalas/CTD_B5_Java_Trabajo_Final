package com.dh.backend1.martin.finalclinicaodontologica;

import com.dh.backend1.martin.finalclinicaodontologica.exceptions.PacienteSinDomicilioException;
import com.dh.backend1.martin.finalclinicaodontologica.exceptions.TurnoConFechaPasadaException;
import com.dh.backend1.martin.finalclinicaodontologica.exceptions.TurnoConIdException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosErrores(Exception ex, WebRequest req) {

        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(PacienteSinDomicilioException.class)
    public ResponseEntity<?> pacienteSinDomicilio(PacienteSinDomicilioException ex, WebRequest req) {

        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TurnoConIdException.class)
    public ResponseEntity<?> turnoConId(TurnoConIdException ex, WebRequest req) {

        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TurnoConFechaPasadaException.class)
    public ResponseEntity<?> turnoConFechaPasada(TurnoConFechaPasadaException ex, WebRequest req) {

        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
