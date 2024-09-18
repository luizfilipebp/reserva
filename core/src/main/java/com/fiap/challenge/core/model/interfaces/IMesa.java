package com.fiap.challenge.core.model.interfaces;

public interface IMesa {
    void reservar(int quantidadePessoas) throws Exception;
    void limpar();
    void disponibilizar();
    boolean verificarDisonibilidade();
}
