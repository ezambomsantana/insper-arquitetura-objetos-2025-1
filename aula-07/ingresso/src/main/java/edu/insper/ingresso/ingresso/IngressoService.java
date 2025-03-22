package edu.insper.ingresso.ingresso;

import edu.insper.ingresso.evento.Evento;
import edu.insper.ingresso.evento.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class IngressoService {

    @Autowired
    private EventoService eventoService;

    HashMap<Integer, Ingresso> ingressos = new HashMap<>();

    public HashMap<Integer, Ingresso> getIngressos(String nomeEvento) {
        if (nomeEvento != null) {
            HashMap<Integer, Ingresso> response = new HashMap<>();
            for (Integer id : ingressos.keySet()) {
                Ingresso ingresso = ingressos.get(id);
                if (ingresso.getEvento().getNome().equals(nomeEvento)) {
                    response.put(id, ingresso);
                }
            }
            return response;
        }
        return ingressos;
    }

    public Ingresso getIngresso(Integer id) {
        return ingressos.get(id);
    }

    public Ingresso salvarIngresso(Ingresso ingresso) {
        Evento evento = eventoService.getEvento(ingresso.getEvento().getId());
        if (evento == null) {
            return null;
        }

        int id = new Random().nextInt(999999);
        while (ingressos.containsKey(id)) {
            id = new Random().nextInt(999999);
        }
        ingresso.setId(id);
        ingresso.setEvento(evento);
        return ingressos.put(id, ingresso);
    }

    public Ingresso deleteIngresso(Integer id) {
        Ingresso ingresso = getIngresso(id);
        if (ingresso != null) {
            ingressos.remove(id);
        }
        return ingresso;
    }

}
