// application/src/main/java/com/fiap/challenge/application/validator/ReservaValidator.java
package com.fiap.challenge.application.usecaseimpl.reserva;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.Dia;
import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;

public class ReservaValidator {

    private final BuscarReservaGateway buscarReserva;

    public ReservaValidator(BuscarReservaGateway buscarReserva) {
        this.buscarReserva = buscarReserva;
    }

    public void validarRestauranteAberto(Restaurante restaurante, Reserva reserva) {
        restaurante.getDiasFuncionamento()
                .stream()
                .filter(dia -> Dia.fromCodigo(reserva.getDataHora().getDayOfWeek().name().toLowerCase()).equals(dia.dia()) &&
                        dia.horaAbertura().isBefore(reserva.getDataHora().toLocalTime()) &&
                        dia.horaFechamento().isAfter(reserva.getDataHora().toLocalTime()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Restaurante fechado"));
    }

    public void validarQuantidadePessoas(Reserva reserva, Restaurante restaurante) {
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