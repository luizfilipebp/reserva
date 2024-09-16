package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.CadastrarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.Dia;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;

public class CadastrarReservaUseCaseImpl implements CadastrarReservaUseCase {
    CadastrarReservaGateway reservaGateway;

    BuscarRestauranteGateway restauranteGateway;

    public CadastrarReservaUseCaseImpl(CadastrarReservaGateway reservaGateway, BuscarRestauranteGateway restauranteGateway) {
        this.reservaGateway = reservaGateway;
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Reserva cadastrar(Reserva reserva) throws IllegalArgumentException {
        validarReserva(reserva);

        Restaurante restaurante = restauranteGateway.findById(reserva.getIdMesa())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        validarRestauranteAberto(restaurante, reserva);
        return reservaGateway.cadastrar(reserva);
    }

    private void validarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva inválida");
        }
    }

    private void validarRestauranteAberto(Restaurante restaurante, Reserva reserva) {
        restaurante.getDiasFuncionamento()
                .stream()
                .filter(dia -> Dia.fromCodigo(reserva.getDataHora().getDayOfWeek().name().substring(0, 3).toLowerCase()).equals(dia.dia()) &&
                        dia.horaAbertura().isBefore(reserva.getDataHora().toLocalTime()) &&
                        dia.horaFechamento().isAfter(reserva.getDataHora().toLocalTime()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Restaurante fechado"));
    }
}


