package org.example;

public interface CRUDService<T> {

    void salvar(T t);
    void excluir(T t);
    void editar(T t);

}
