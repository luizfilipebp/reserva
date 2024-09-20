package com.fiap.challenge.infrastructure.config;

import com.fiap.challenge.application.gateway.mesa.AtualizarStatusMesaGateway;
import com.fiap.challenge.application.gateway.mesa.BuscarMesaGateway;
import com.fiap.challenge.application.gateway.mesa.CadastrarMesaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.application.usecaseimpl.mesa.AtualizarStatusMesaUseCaseImpl;
import com.fiap.challenge.application.usecaseimpl.mesa.BuscarMesaUseCaseImpl;
import com.fiap.challenge.application.usecaseimpl.mesa.CadastrarMesaUseCaseImpl;
import com.fiap.challenge.usecase.mesa.AtualizarStatusMesaUseCase;
import com.fiap.challenge.usecase.mesa.BuscarMesaUseCase;
import com.fiap.challenge.usecase.mesa.CadastrarMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MesaConfig {
    @Bean
    CadastrarMesaUseCase cadastrarMesaUseCase(CadastrarMesaGateway cadastrarMesa, BuscarRestauranteGateway buscarRestaurante) {
        return new CadastrarMesaUseCaseImpl(cadastrarMesa, buscarRestaurante);
    }

    @Bean
    BuscarMesaUseCase buscarMesaUseCase(BuscarMesaGateway buscarMesa) {
        return new BuscarMesaUseCaseImpl(buscarMesa);
    }

    @Bean
    AtualizarStatusMesaUseCase atualizarStatusMesaUseCase(BuscarMesaGateway buscarMesa, AtualizarStatusMesaGateway atualizarMesa) {
        return new AtualizarStatusMesaUseCaseImpl(buscarMesa, atualizarMesa);
    }
}
