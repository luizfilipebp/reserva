package com.fiap.challenge.usecase.mesa;

import com.fiap.challenge.core.model.Mesa;

public interface BuscarMesaUseCase {
    Mesa buscarPeloId(Long idMesa);
}
