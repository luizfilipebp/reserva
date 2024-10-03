package com.fiap.challenge.usecase.restaurante;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.Usuario;

public interface ComentarRestauranteUseCase {

    void comentar (Restaurante restaurante, Usuario usuario, String comentario);
}
