package com.fiap.challenge.application.usecaseimpl.restaurante;

import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.usecase.restaurante.BuscarRestauranteUseCase;

import java.util.List;
import java.util.Optional;

public class BuscarRestauranteUseCaseImpl implements BuscarRestauranteUseCase {

    BuscarRestauranteGateway restauranteGateway;

    public BuscarRestauranteUseCaseImpl(BuscarRestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public List<Restaurante> buscarTodos(int size, int page) {
        return restauranteGateway.findAll(size, page);
    }

    @Override
    public List<Restaurante> buscarPorNome(String nome, int size, int page) {
        return restauranteGateway.findByNome(nome, size, page);
    }

    @Override
    public List<Restaurante> buscarPorLocalizacao(Endereco localizacao) {

        return switch (
                        Optional.ofNullable(localizacao.logradouro()).isPresent() ? "LOGRADOURO" :
                        Optional.ofNullable(localizacao.bairro()).isPresent() ? "BAIRRO" :
                        Optional.ofNullable(localizacao.cidade()).isPresent() ? "CIDADE" : "DEFAULT"
                ) {
            case "LOGRADOURO" -> restauranteGateway.findByLogradouro(localizacao.logradouro());
            case "BAIRRO" -> restauranteGateway.findByBairro(localizacao.bairro());
            case "CIDADE" -> restauranteGateway.findByCidade(localizacao.cidade());
            default -> throw new IllegalArgumentException("Endereço inválido.");
        };
    }

    @Override
    public List<Restaurante> buscarPorTipoDeCozinha(TipoCozinha tipoDeCozinha) {
        return restauranteGateway.findByTipo(tipoDeCozinha);
    }
}
