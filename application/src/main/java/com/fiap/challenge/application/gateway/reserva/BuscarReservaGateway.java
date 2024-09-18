package com.fiap.challenge.application.gateway.reserva;

import com.fiap.challenge.core.model.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarReservaGateway {

   List<Reserva> findByDataHora(LocalDateTime dataHora);
}
