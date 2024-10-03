package com.fiap.challenge.application.gateway.reserva;

import com.fiap.challenge.core.model.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarReservaGateway {
    Reserva findById(Long id) throws RuntimeException;
    List<Reserva> findByIdUsuario(String idUsuario);
    List<Reserva> findByDataHora(LocalDateTime dataHora);
    List<Reserva> findAll(int page, int size);
}
