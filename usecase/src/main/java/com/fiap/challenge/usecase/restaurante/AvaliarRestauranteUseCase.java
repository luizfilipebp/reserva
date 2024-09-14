package com.fiap.challenge.usecase.restaurante;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.Usuario;

public interface AvaliarRestauranteUseCase {
    void avaliar(Restaurante restaurante, Usuario usuario, String avaliacao);
}
