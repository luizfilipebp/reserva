package com.fiap.challenge.usecase.reserva;

import com.fiap.challenge.core.model.Reserva;

public interface BuscarReservaUseCase {
    Reserva buscar(Long idReserva);
}
