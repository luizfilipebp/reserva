package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.usecase.reserva.BuscarReservaUseCase;

import java.util.List;

public class BuscarReservaUseCaseImpl implements BuscarReservaUseCase {
    private final BuscarReservaGateway buscarReserva;

    public BuscarReservaUseCaseImpl(BuscarReservaGateway buscarReserva) {
        this.buscarReserva = buscarReserva;
    }

    @Override
    public List<Reserva> buscarTodos(int page, int size) {
        return buscarReserva.findAll(page, size);
    }

    @Override
    public Reserva buscarPorId(Long idReserva) {
        return buscarReserva.findById(idReserva);
    }

    @Override
    public List<Reserva> buscarPeloIdUsuario(String idUsuario) {
        return buscarReserva.findByIdUsuario(idUsuario);
    }
}
