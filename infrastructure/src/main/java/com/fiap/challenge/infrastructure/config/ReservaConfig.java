package com.fiap.challenge.infrastructure.config;

import com.fiap.challenge.application.gateway.BuscarReservaGateway;
import com.fiap.challenge.application.gateway.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.CadastrarReservaGateway;
import com.fiap.challenge.application.usecaseimpl.reserva.CadastrarReservaUseCaseImpl;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaConfig {
    @Bean
    CadastrarReservaUseCase cadastrarReservaUseCase(CadastrarReservaGateway reservaGateway, BuscarRestauranteGateway restauranteGateway, BuscarReservaGateway buscarReserva) {
        return new CadastrarReservaUseCaseImpl(reservaGateway, buscarReserva, restauranteGateway);
    }
}
