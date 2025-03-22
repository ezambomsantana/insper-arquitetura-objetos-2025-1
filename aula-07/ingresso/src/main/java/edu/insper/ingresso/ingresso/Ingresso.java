package edu.insper.ingresso.ingresso;

import edu.insper.ingresso.evento.Evento;

public class Ingresso {

    private int id;
    private String cpf;
    private Evento evento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
