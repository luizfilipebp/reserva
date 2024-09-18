package com.fiap.challenge.infrastructure.config;

import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.application.gateway.restaurante.CadastrarRestauranteGateway;
import com.fiap.challenge.application.usecaseimpl.restaurante.BuscarRestauranteUseCaseImp;
import com.fiap.challenge.application.usecaseimpl.restaurante.CadastrarRestauranteUseCaseImpl;
import com.fiap.challenge.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.challenge.usecase.restaurante.CadastrarRestauranteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteConfig {
    @Bean
    BuscarRestauranteUseCase buscarRestauranteUseCase(BuscarRestauranteGateway restauranteGateway){
        return new BuscarRestauranteUseCaseImp(restauranteGateway);
    }


    @Bean
    CadastrarRestauranteUseCase cadastrarRestauranteUseCase(CadastrarRestauranteGateway restauranteGateway){
        return new CadastrarRestauranteUseCaseImpl(restauranteGateway);
    }

}
