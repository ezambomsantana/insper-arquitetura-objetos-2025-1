package edu.insper.ingresso.ingresso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class IngressoController {


    @Autowired
    private IngressoService ingressoService;

    @GetMapping("/ingresso")
    public HashMap<Integer, Ingresso> getIngressos(
            @RequestParam(required = false) String nomeEvento) {
        return ingressoService.getIngressos(nomeEvento);
    }

    @GetMapping("/ingresso/{id}")
    public Ingresso getIngresso(@PathVariable Integer id) {
        Ingresso ingresso = ingressoService.getIngresso(id);
        if (ingresso != null) {
            return ingresso;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingresso não encontrado");
    }

    @PostMapping("/ingresso")
    public Ingresso salvarIngresso(@RequestBody Ingresso ingresso) {

        if (ingresso.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF é obrigatório");
        }

        return ingressoService.salvarIngresso(ingresso);
    }

    @DeleteMapping("/ingresso/{id}")
    public Ingresso deleteIngresso(@PathVariable Integer id) {
        Ingresso ingresso = ingressoService.deleteIngresso(id);
        if (ingresso != null) {
            return ingresso;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingresso não encontrado");
    }
}
