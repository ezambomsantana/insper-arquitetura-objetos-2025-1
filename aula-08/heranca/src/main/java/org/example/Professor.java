package org.example;

public class Professor extends Pessoa implements Avaliador {

    private Integer cargaHorario;

    public void avaliar(Aluno aluno) {

    }

    @Override
    public void imprimir() {
        System.out.println(nome);
        System.out.println(cargaHorario);
    }

    @Override
    public void cadastrarDisciplina(String nomeDisciplina) {

    }

    public Integer getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(Integer cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    @Override
    public void avaliar(Pessoa pessoa) {

    }
}
