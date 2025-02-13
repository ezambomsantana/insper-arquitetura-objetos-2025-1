package org.example;

import java.util.ArrayList;

public class Filme {
    String nome;
    int ano;
    ArrayList<String> atores = new ArrayList<>();

    Integer addAtores(String nome) {
        if (!nome.isEmpty()) {
            atores.add(nome);
            return 0;
        }
        return null;
    }
}
