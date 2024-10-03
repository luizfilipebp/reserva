package com.fiap.challenge.application.gateway.mesa;

import com.fiap.challenge.core.model.Mesa;

import java.util.Optional;

public interface BuscarMesaGateway {
    Optional<Mesa> buscarPeloId(Long idMesa);
}
