package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusMesa;
import com.fiap.challenge.core.model.interfaces.IMesa;

public class Mesa implements IMesa {
    private long id;
    private long idRestaurante;
    private StatusMesa status;
    private int capacidade;

    public Mesa(Long id, Long idRestaurante, int capacidade) {
        this.id = id;
        this.idRestaurante = idRestaurante;
        this.status = StatusMesa.DISPONIVEL;
        this.capacidade = capacidade;
    }

    public void reservar(int quantidadePessoas) throws Exception {
        if (!verificarDisonibilidade()) {
            throw new Exception("Mesa não está disponível para reserva");
        }

        if (quantidadePessoas > this.capacidade) {
            throw new Exception("Quantidade de pessoas maior que a capacidade da mesa");
        }

        this.status = StatusMesa.RESERVADA;
    }

    @Override
    public void limpar() {
        this.status = StatusMesa.EM_LIMPEZA;
    }

    @Override
    public void disponibilizar() {
        this.status = StatusMesa.DISPONIVEL;
    }

    @Override
    public boolean verificarDisonibilidade() {
        return this.status == StatusMesa.DISPONIVEL;
    }


    public long getId() {
        return id;
    }

    public long getIdRestaurante() {
        return idRestaurante;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
