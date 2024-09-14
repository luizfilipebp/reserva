package com.fiap.challenge.application.usecaseimpl.restaurante;

import com.fiap.challenge.application.gateway.CadastrarRestauranteGateway;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.usecase.restaurante.CadastrarRestauranteUseCase;

public class CadastrarRestauranteUseCaseImpl implements CadastrarRestauranteUseCase {

    CadastrarRestauranteGateway restauranteGateway;

    public CadastrarRestauranteUseCaseImpl(CadastrarRestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante cadastrar(Restaurante restaurante) {
        return restauranteGateway.cadastrar(restaurante);
    }
}
