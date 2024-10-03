package com.fiap.challenge.application.usecaseimpl.mesa;

import com.fiap.challenge.application.gateway.mesa.AtualizarStatusMesaGateway;
import com.fiap.challenge.application.gateway.mesa.BuscarMesaGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.usecase.mesa.AtualizarStatusMesaUseCase;

public class AtualizarStatusMesaUseCaseImpl implements AtualizarStatusMesaUseCase {
    private final BuscarMesaGateway buscarMesa;
    private final AtualizarStatusMesaGateway atualizarMesa;

    public AtualizarStatusMesaUseCaseImpl(BuscarMesaGateway buscarMesa, AtualizarStatusMesaGateway atualizarStatusMesaGateway) {
        this.buscarMesa = buscarMesa;
        this.atualizarMesa = atualizarStatusMesaGateway;
    }

    @Override
    public Mesa disponibilizarMesa(Long idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        mesa.disponibilizar();
        return atualizarMesa.atualizarStatus(mesa);
    }

    @Override
    public Mesa ocuparMesa(Long idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        mesa.ocupar();
        return atualizarMesa.atualizarStatus(mesa);
    }

    @Override
    public Mesa reservarMesa(Long idMesa) {
        return null;
    }

    @Override
    public Mesa limparMesa(Long idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        mesa.limpar();
        return atualizarMesa.atualizarStatus(mesa);
    }

    @Override
    public Mesa indisponibilizarMesa(Long idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        mesa.indisponibilizar();
        Mesa mesa1 = atualizarMesa.atualizarStatus(mesa);
        System.out.println(mesa1.toString());

        return mesa1;
    }


    private Mesa buscarMesa(Long idMesa) {
        return buscarMesa.buscarPeloId(idMesa).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
    }
}
