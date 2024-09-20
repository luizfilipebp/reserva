package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusMesa;
import com.fiap.challenge.core.model.interfaces.IMesa;

public class Mesa implements IMesa {
    private long id;
    private long idRestaurante;
    private StatusMesa status;
    private int capacidade;

    public Mesa(Long id, Long idRestaurante, StatusMesa status, int capacidade) {
        this.id = id;
        this.idRestaurante = idRestaurante;
        this.status = (status == null) ? StatusMesa.DISPONIVEL : status;
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

    public void indisponibilizar() {
        this.status = StatusMesa.INDISPONIVEL;
    }

    public void ocupar() {
        if (!this.status.equals(StatusMesa.DISPONIVEL)) {
            throw new RuntimeException("Mesa somente pode ser ocupada se estiver disponível");
        }

        this.status = StatusMesa.OCUPADA;
    }

    @Override
    public void limpar() {
        this.status = StatusMesa.EM_LIMPEZA;
    }

    @Override
    public void disponibilizar() {
        if(!this.status.equals(StatusMesa.EM_LIMPEZA)){
            throw new RuntimeException("Mesa somente pode ser disponibilizada se estiver em limpeza");
        }

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


    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", idRestaurante=" + idRestaurante +
                ", status=" + status +
                ", capacidade=" + capacidade +
                '}';
    }
}
