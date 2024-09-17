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
        Restaurante restaurante = restauranteGateway.findById(reserva.getIdRestaurante())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        validarRestauranteAberto(restaurante, reserva);
        validarQuantidadePessoas(reserva, restaurante);

        return reservaGateway.cadastrar(reserva);
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
            throw new IllegalArgumentException("Quantidade de pessoas da reserva ultrapassa a capacidade do restaurante");
        }

        int totalPessoas = buscarReserva.findByDataHora(reserva.getDataHora())
                .stream()
                .filter(r -> r.getIdRestaurante().equals(reserva.getIdRestaurante()))
                .mapToInt(Reserva::getQuantidadePessoas)
                .sum();

        if (totalPessoas + reserva.getQuantidadePessoas() > restaurante.getCapacidade()) {
            throw new IllegalArgumentException("Restaurante lotado para esta data e hora");
        }
    }
}


