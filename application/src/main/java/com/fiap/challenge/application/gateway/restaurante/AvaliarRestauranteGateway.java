package com.fiap.challenge.application.gateway.restaurante;

import com.fiap.challenge.core.model.Avaliar;

import java.util.List;
import java.util.Optional;

public interface AvaliarRestauranteGateway {
    Avaliar avaliar(Avaliar avaliar);

    Optional<Avaliar> buscarAvaliacao(Long Id);

    List<Avaliar> buscarAvaliacaoTodos(int page, int size);
}