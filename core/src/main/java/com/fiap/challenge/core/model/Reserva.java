package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusMesa;

import java.time.LocalDateTime;

public class Reserva {
    private long id;
    private String nomeCliente;
    private Long idRestaurante;
    private LocalDateTime dataHora;
    private StatusMesa status;
    private int quantidadePessoas;

    public Reserva(long id, String nomeCliente, Long idRestaurante, LocalDateTime dataHora, StatusMesa status, int quantidadePessoas) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.idRestaurante = idRestaurante;
        this.dataHora = validarDataHora(dataHora);
        this.status = status;
        this.quantidadePessoas = validarQuantidadePessoas(quantidadePessoas);
    }

    private LocalDateTime validarDataHora(LocalDateTime dataHora) throws IllegalArgumentException {
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data e hora inválida");
        }
        return dataHora;
    }

    private int validarQuantidadePessoas(int quantidadePessoas) throws IllegalArgumentException {
        if (quantidadePessoas <= 0) {
            throw new IllegalArgumentException("Quantidade de pessoas inválida");
        }
        return quantidadePessoas;
    }


    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getIdMesa() {
        return idRestaurante;
    }

    public void setIdMesa(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }
}
