package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusMesa;

import java.time.LocalDateTime;

public class Reserva {
    private long id;
    private String nomeCliente;
    private String idMesa;
    private LocalDateTime dataHora;
    private StatusMesa status;
}
