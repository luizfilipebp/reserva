package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.application.gateway.BuscarReservaGateway;
import com.fiap.challenge.application.gateway.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.CadastrarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.Dia;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;

public class CadastrarReservaUseCaseImpl implements CadastrarReservaUseCase {
    CadastrarReservaGateway reservaGateway;

    BuscarReservaGateway buscarReserva;

    BuscarRestauranteGateway restauranteGateway;

    public CadastrarReservaUseCaseImpl(CadastrarReservaGateway reservaGateway, BuscarReservaGateway buscarReserva, BuscarRestauranteGateway restauranteGateway) {
        this.reservaGateway = reservaGateway;
        this.buscarReserva = buscarReserva;
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Reserva cadastrar(Reserva reserva) throws IllegalArgumentException {
        validarReserva(reserva);

        Restaurante restaurante = restauranteGateway.findById(reserva.getIdMesa())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        validarRestauranteAberto(restaurante, reserva);


        validarQuantidadePessoas(reserva, restaurante);

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
                .filter(dia -> Dia.fromCodigo(reserva.getDataHora().getDayOfWeek().name().toLowerCase()).equals(dia.dia()) &&
                        dia.horaAbertura().isBefore(reserva.getDataHora().toLocalTime()) &&
                        dia.horaFechamento().isAfter(reserva.getDataHora().toLocalTime()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Restaurante fechado"));
    }

    private void validarQuantidadePessoas(Reserva reserva, Restaurante restaurante) {

        if (reserva.getQuantidadePessoas() > restaurante.getCapacidade()) {
            throw new IllegalArgumentException("Restaurante sem capacidade para a quantidade de pessoas");
        }


        buscarReserva.findByDataHora(reserva.getDataHora())
                .stream()
                .filter(r -> r.getIdMesa().equals(reserva.getIdMesa()))
                .findFirst()
                .ifPresent(r -> {
                    if (r.getQuantidadePessoas() + reserva.getQuantidadePessoas() > restaurante.getCapacidade()) {
                        throw new IllegalArgumentException("Restaurante sem capacidade para a quantidade de pessoas");
                    }
                });
    }
}


