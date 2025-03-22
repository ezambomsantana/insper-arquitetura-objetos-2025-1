package edu.insper.ingresso.evento;

import edu.insper.ingresso.local.Local;
import edu.insper.ingresso.local.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class EventoService {

    @Autowired
    private LocalService localService;

    HashMap<Integer, Evento> eventos = new HashMap<>();

    public HashMap<Integer, Evento> getEventos() {
        return eventos;
    }

    public boolean temEventoPorLocal(Integer idLocal) {
        for (Evento evento : eventos.values()) {
            if (evento.getLocal().getId().equals(idLocal)) {
                return true;
            }
        }
        return false;
    }

    public Evento getEvento(Integer id) {
        return eventos.get(id);
    }

    public Evento salvarEvento(Evento evento) {
        Local local = localService.getLocal(evento.getLocal().getId());

        temOutroEventoLocalData(evento);

        if (local == null) {
            return null;
        }

        int id = new Random().nextInt(999999);
        while (eventos.containsKey(id)) {
            id = new Random().nextInt(999999);
        }

        evento.setId(id);
        evento.setLocal(local);
        eventos.put(id, evento);
        return evento;
    }

    private void temOutroEventoLocalData(Evento evento) {

        for (Evento eventoCompara : eventos.values()) {
            if (eventoCompara.getData().equals(evento.getData()) &&
                eventoCompara.getLocal().getId().equals(evento.getLocal().getId())) {
                throw new EventoSameDateAndLocalException();
            }
        }

    }

    public Evento deleteEvento(Integer id) {
        Evento evento = getEvento(id);
        if (evento != null) {
            eventos.remove(id);
        }
        return evento;
    }
}
