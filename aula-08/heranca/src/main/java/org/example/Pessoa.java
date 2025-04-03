package org.example;

public abstract class Pessoa {
    protected String nome;
    protected String email;

    public void imprimir() {
        System.out.println(nome);
        System.out.println(email);
    }

    public abstract void cadastrarDisciplina(String nomeDisciplina);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
