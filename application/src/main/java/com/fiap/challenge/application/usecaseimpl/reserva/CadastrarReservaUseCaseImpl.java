package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.reserva.CadastrarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;

public class CadastrarReservaUseCaseImpl implements CadastrarReservaUseCase {
    private final CadastrarReservaGateway reservaGateway;
    private final BuscarRestauranteGateway restauranteGateway;
    private final ReservaValidator reservaValidator;

    public CadastrarReservaUseCaseImpl(CadastrarReservaGateway reservaGateway, BuscarReservaGateway buscarReserva, BuscarRestauranteGateway restauranteGateway) {
        this.reservaGateway = reservaGateway;
        this.restauranteGateway = restauranteGateway;
        this.reservaValidator = new ReservaValidator(buscarReserva);
    }

    @Override
    public Reserva cadastrar(Reserva reserva) throws IllegalArgumentException {
        Restaurante restaurante = restauranteGateway.findById(reserva.getIdRestaurante())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        reservaValidator.validarRestauranteAberto(restaurante, reserva);
        reservaValidator.validarQuantidadePessoas(reserva, restaurante);

        return reservaGateway.cadastrar(reserva);
    }
}