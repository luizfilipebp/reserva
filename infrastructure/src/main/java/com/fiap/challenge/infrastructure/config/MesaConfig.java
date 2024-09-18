package com.fiap.challenge.infrastructure.config;

import com.fiap.challenge.application.gateway.mesa.CadastrarMesaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.application.usecaseimpl.mesa.CadastrarMesaUseCaseImp;
import com.fiap.challenge.usecase.mesa.CadastrarMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MesaConfig {
    @Bean
    CadastrarMesaUseCase cadastrarMesaUseCase(CadastrarMesaGateway cadastrarMesa, BuscarRestauranteGateway buscarRestaurante){
        return new CadastrarMesaUseCaseImp(cadastrarMesa, buscarRestaurante);
    }
}
