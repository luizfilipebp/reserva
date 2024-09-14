package com.fiap.challenge.infrastructure.service;

import com.fiap.challenge.application.gateway.CadastrarRestauranteGateway;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.infrastructure.entity.RestauranteEntity;
import com.fiap.challenge.infrastructure.mapper.RestauranteMapper;
import com.fiap.challenge.infrastructure.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarRestauranteGatewayImpl implements CadastrarRestauranteGateway {

    RestauranteRepository repository;

    @Override
    public Restaurante cadastrar(Restaurante restaurante) {
        RestauranteEntity restauranteEntity = RestauranteMapper.INSTANCE.restauranteToRestauranteEntity(restaurante);

        RestauranteEntity saved = repository.save(restauranteEntity);

        return RestauranteMapper.INSTANCE.restauranteEntityToRestaurante(saved);
    }
}
