package org.example;

public class Aluno extends Pessoa implements Avaliador {
    private String curso;


    public void avaliar(Professor professor) {

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void cadastrarDisciplina(String nomeDisciplina) {

    }

    @Override
    public void avaliar(Pessoa pessoa) {

    }

    @Override
    public String feedback() {
        return "";
    }
}
