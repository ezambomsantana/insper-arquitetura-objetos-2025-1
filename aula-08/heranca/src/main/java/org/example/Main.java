package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Aluno");
        aluno.setEmail("aluno@aluno.com");
        aluno.setCurso("ccomp");

        Professor professor = new Professor();
        professor.setNome("Eduardo");
        professor.setEmail("aa@aa.com");
        professor.setCargaHorario(10);

        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(professor);
        lista.add(aluno);

        ArrayList<Pessoa> l = (ArrayList<Pessoa>) lista.clone();

        PessoaService pessoaService = new PessoaService();
        pessoaService.imprimirPessoa(professor);
        pessoaService.imprimirPessoa(aluno);

        Avaliador avaliador = new Aluno();
        avaliador.avaliar(professor);

    }
}