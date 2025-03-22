package edu.insper.ingresso.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("/local")
    public HashMap<Integer, Local> getLocais() {
        return localService.getLocais();
    }

    @GetMapping("/local/{id}")
    public Local getLocal(@PathVariable Integer id) {
        Local local = localService.getLocal(id);
        if (local != null) {
            return local;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado");
    }

    @PostMapping("/local")
    public Local salvarLocal(@RequestBody Local local) {

        if (local.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do local é obrigatório");
        }

        if (local.getCapacidade() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Capacidade deve ser maior que 0");
        }

        if (local.getEndereco() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço é obrigatório");
        }

        return localService.salvarLocal(local);
    }

    @DeleteMapping("/local/{id}")
    public Local deleteLocal(@PathVariable Integer id) {
        Local local = localService.deleteLocal(id);
        if (local != null) {
            return local;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado");
    }
}
