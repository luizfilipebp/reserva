package com.fiap.challenge.application.usecaseimpl.mesa;

import com.fiap.challenge.application.gateway.mesa.BuscarMesaGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.usecase.mesa.BuscarMesaUseCase;

public class BuscarMesaUseCaseImpl implements BuscarMesaUseCase {
    private final BuscarMesaGateway buscarMesaGateway;

    public BuscarMesaUseCaseImpl(BuscarMesaGateway buscarMesaGateway) {
        this.buscarMesaGateway = buscarMesaGateway;
    }

    @Override
    public Mesa buscarPeloId(Long idMesa) {
        return buscarMesaGateway.buscarPeloId(idMesa).orElseThrow(() -> new IllegalArgumentException("Mesa não encontrada? " + idMesa));
    }
}
