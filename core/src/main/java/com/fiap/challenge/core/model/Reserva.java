package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusReserva;
import com.fiap.challenge.core.model.interfaces.IMesa;

import java.time.LocalDateTime;

public class Reserva {
    private long id;
    private String idUsuario;
    private Long idRestaurante;
    private LocalDateTime dataHora;
    private StatusReserva status;
    private int quantidadePessoas;

    public Reserva(long id, String idUsuario, Long idRestaurante, LocalDateTime dataHora, int quantidadePessoas) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idRestaurante = idRestaurante;
        this.dataHora = validarDataHora(dataHora);
        this.status = StatusReserva.PENDENTE;
        this.quantidadePessoas = validarQuantidadePessoas(quantidadePessoas);
    }


    public void cancelarReserva(){
        this.status = StatusReserva.CANCELADA;
    }

    public void confirmarReserva(){
        this.status = StatusReserva.CONFIRMADA;
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


    public long getId() {
        return id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
}
