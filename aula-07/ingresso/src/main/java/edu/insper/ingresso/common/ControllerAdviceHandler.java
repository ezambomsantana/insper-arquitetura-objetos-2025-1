package edu.insper.ingresso.common;


import edu.insper.ingresso.evento.EventoSameDateAndLocalException;
import edu.insper.ingresso.local.LocalHasEventException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> responseStatusException(ResponseStatusException exception) {

        ErrorDTO errorDTO = new ErrorDTO(
                exception.getReason(),
                exception.getStatusCode().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exception.getStatusCode()).body(errorDTO);


    }

    @ExceptionHandler(LocalHasEventException.class)
    public ResponseEntity<ErrorDTO> cartaoNotFoundException(LocalHasEventException exception) {
        ErrorDTO errorDTO = new ErrorDTO(
                "O local não pode ser excluído pois tem eventos marcados",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(EventoSameDateAndLocalException.class)
    public ResponseEntity<ErrorDTO> cartaoNotFoundException(EventoSameDateAndLocalException exception) {
        ErrorDTO errorDTO = new ErrorDTO(
                "Já existe evento no mesmo local e data",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

}
