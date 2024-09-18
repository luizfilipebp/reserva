package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.reserva.AtualizarReservaGateway;
import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.StatusReserva;
import com.fiap.challenge.usecase.reserva.AtualizarReservaUseCase;

public class AtualizarReservaUseCaseImpl implements AtualizarReservaUseCase {

    private final AtualizarReservaGateway atualizarReserva;
    private final BuscarReservaGateway buscarReserva;
    private final BuscarRestauranteGateway buscarRestaurante;
    private final ReservaValidator reservaValidator;

    public AtualizarReservaUseCaseImpl(AtualizarReservaGateway atualizarReserva, BuscarReservaGateway buscarReserva, BuscarRestauranteGateway buscarRestaurante) {
        this.atualizarReserva = atualizarReserva;
        this.buscarReserva = buscarReserva;
        this.buscarRestaurante = buscarRestaurante;
        this.reservaValidator = new ReservaValidator(buscarReserva);
    }

    @Override
    public Reserva atualizar(Reserva reserva) {
        Reserva reservaExistente = buscarReserva.findById(reserva.getId())
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        if (!reserva.getStatus().equals(StatusReserva.PENDENTE)) {
            throw new IllegalArgumentException("Reserva só pode ser atualizada se estiver pendente de confirmação");
        }

        Restaurante restaurante = buscarRestaurante.findById(reservaExistente.getIdRestaurante())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        reservaValidator.validarRestauranteAberto(restaurante, reserva);
        reservaValidator.validarQuantidadePessoas(reserva, restaurante);

        reservaExistente.setDataHora(reserva.getDataHora());
        reservaExistente.setQuantidadePessoas(reserva.getQuantidadePessoas());

        return atualizarReserva.atualizar(reservaExistente);
    }
}