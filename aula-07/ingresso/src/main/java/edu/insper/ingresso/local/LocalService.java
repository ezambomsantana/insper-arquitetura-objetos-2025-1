package edu.insper.ingresso.local;

import edu.insper.ingresso.evento.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class LocalService {

    HashMap<Integer, Local> locais = new HashMap<>();

    public HashMap<Integer, Local> getLocais() {
        return locais;
    }

    public Local getLocal(Integer id) {
        return locais.get(id);
    }

    public Local salvarLocal(Local local) {

        int id = new Random().nextInt(999999);
        while (locais.containsKey(id)) {
            id = new Random().nextInt(999999);
        }
        local.setId(id);
        locais.put(id, local);
        return local;
    }

    public Local deleteLocal(Integer id) {
        Local local = getLocal(id);

        if (local != null) {
            locais.remove(id);
        }

        return local;
    }
}
