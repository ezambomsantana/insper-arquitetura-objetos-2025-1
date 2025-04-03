package br.edu.insper.banco.cartao;

public class StatusCartaoDTO {
    private String numeroCartao;
    private Cartao.StatusCartao statusCartao;

    public StatusCartaoDTO(String numeroCartao, Cartao.StatusCartao statusCartao) {
        this.numeroCartao = numeroCartao;
        this.statusCartao = statusCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Cartao.StatusCartao getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(Cartao.StatusCartao statusCartao) {
        this.statusCartao = statusCartao;
    }
}
