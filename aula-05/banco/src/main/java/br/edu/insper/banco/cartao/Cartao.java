package br.edu.insper.banco.cartao;

public class Cartao {

    enum TipoCartao {
        DEBITO, CREDITO;
    }

    enum Status {
        VALIDO, BLOQUEADO, VENCIDO;
    }


    private TipoCartao tipo;
    private Status status;

    public TipoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoCartao tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
