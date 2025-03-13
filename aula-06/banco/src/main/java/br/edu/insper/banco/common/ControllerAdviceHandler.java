package br.edu.insper.banco.common;


import br.edu.insper.banco.cartao.CartaoNotFoundException;
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

    @ExceptionHandler(CartaoNotFoundException.class)
    public ResponseEntity<ErrorDTO> cartaoNotFoundException(CartaoNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO(
                "Cartão não encontrado",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

}
