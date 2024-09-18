package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.reserva.AtualizarReservaGateway;
import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.usecase.reserva.CancelarReservaUseCase;

public class CancelarReservaUseCaseImpl implements CancelarReservaUseCase {

    private final BuscarReservaGateway buscarReserva;

    private final AtualizarReservaGateway atualizarReserva;

    public CancelarReservaUseCaseImpl(BuscarReservaGateway buscarReserva, AtualizarReservaGateway atualizarReserva) {
        this.buscarReserva = buscarReserva;
        this.atualizarReserva = atualizarReserva;
    }

    @Override
    public void cancelar(Long idReserva) {
        Reserva reserva = buscarReserva.findById(idReserva).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.cancelarReserva();

        atualizarReserva.atualizar(reserva);

    }
}
