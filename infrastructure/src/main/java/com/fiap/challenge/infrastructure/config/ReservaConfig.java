package com.fiap.challenge.infrastructure.config;

import com.fiap.challenge.application.gateway.reserva.AtualizarReservaGateway;
import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.reserva.CadastrarReservaGateway;
import com.fiap.challenge.application.usecaseimpl.reserva.AtualizarReservaUseCaseImpl;
import com.fiap.challenge.application.usecaseimpl.reserva.BuscarReservaUseCaseImpl;
import com.fiap.challenge.application.usecaseimpl.reserva.CadastrarReservaUseCaseImpl;
import com.fiap.challenge.application.usecaseimpl.reserva.CancelarReservaUseCaseImpl;
import com.fiap.challenge.usecase.reserva.AtualizarReservaUseCase;
import com.fiap.challenge.usecase.reserva.BuscarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CancelarReservaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaConfig {
    @Bean
    CadastrarReservaUseCase cadastrarReservaUseCase(CadastrarReservaGateway reservaGateway, BuscarRestauranteGateway restauranteGateway, BuscarReservaGateway buscarReserva) {
        return new CadastrarReservaUseCaseImpl(reservaGateway, buscarReserva, restauranteGateway);
    }

    @Bean
    AtualizarReservaUseCase atualizarReservaUseCase(AtualizarReservaGateway atualizarReserva, BuscarReservaGateway buscarReserva, BuscarRestauranteGateway restauranteRestaurante) {
        return new AtualizarReservaUseCaseImpl(atualizarReserva, buscarReserva, restauranteRestaurante);
    }


    @Bean
    CancelarReservaUseCase cancelarReservaUseCase(BuscarReservaGateway buscarReserva, AtualizarReservaGateway atualizarReserva) {
        return new CancelarReservaUseCaseImpl(buscarReserva, atualizarReserva);

    }

    @Bean
    BuscarReservaUseCase buscarReservaUseCase(BuscarReservaGateway buscarReserva) {
        return new BuscarReservaUseCaseImpl(buscarReserva);
    }
}
