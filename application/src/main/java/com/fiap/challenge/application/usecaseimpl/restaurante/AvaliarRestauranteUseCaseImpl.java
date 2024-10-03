package com.fiap.challenge.application.usecaseimpl.restaurante;

import com.fiap.challenge.application.gateway.restaurante.AvaliarRestauranteGateway;
import com.fiap.challenge.core.model.Avaliar;
import com.fiap.challenge.usecase.restaurante.AvaliarRestauranteUseCase;

import java.util.List;
import java.util.Optional;

public class AvaliarRestauranteUseCaseImpl implements AvaliarRestauranteUseCase {
    AvaliarRestauranteGateway avaliarRestauranteGateway;

    public AvaliarRestauranteUseCaseImpl(AvaliarRestauranteGateway avaliarRestauranteGateway) {
        this.avaliarRestauranteGateway = avaliarRestauranteGateway;
    }

    @Override
    public Avaliar avaliarRestaurante(Avaliar avaliar) {
        return avaliarRestauranteGateway.avaliar(avaliar);
    }

    @Override
    public Optional<Avaliar> buscarAvaliacaoPorId(long id) {
        return avaliarRestauranteGateway.buscarAvaliacao(id);
    }

    @Override
    public List<Avaliar> buscarAvaliacaoTodos(int page, int size) {return avaliarRestauranteGateway.buscarAvaliacaoTodos(page, size);};
}
