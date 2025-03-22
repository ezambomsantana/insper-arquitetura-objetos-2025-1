package edu.insper.ingresso.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class EventoController {


    @Autowired
    private EventoService eventoService;

    @GetMapping("/evento")
    public HashMap<Integer, Evento> getEventos() {
        return eventoService.getEventos();
    }

    @GetMapping("/evento/{id}")
    public Evento getEvento(@PathVariable Integer id) {
        Evento evento = eventoService.getEvento(id);
        if (evento != null) {
            return evento;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado");
    }

    @PostMapping("/evento")
    public Evento salvarEvento(@RequestBody Evento evento) {

        if (evento.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do evento é obrigatório");
        }

        if (evento.getValor() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preço deve ser maior que 0");
        }

        if (evento.getData() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data do evento é obrigatória");
        }

        return eventoService.salvarEvento(evento);
    }

    @DeleteMapping("/evento/{id}")
    public Evento deleteEvento(@PathVariable Integer id) {
        Evento evento = eventoService.deleteEvento(id);
        if (evento != null) {
            return evento;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado");
    }

}
