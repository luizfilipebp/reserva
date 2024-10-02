package com.fiap.challenge.usecase.restaurante;

import com.fiap.challenge.core.model.Avaliar;

import java.util.List;
import java.util.Optional;

public interface AvaliarRestauranteUseCase {
    Avaliar avaliarRestaurante(Avaliar avaliar);

    Optional<Avaliar> buscarAvaliacaoPorId (long id);

    List<Avaliar> buscarAvaliacaoTodos(int page, int size);
}
