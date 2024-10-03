package com.fiap.challenge.application.usecaseimpl.mesa;

import com.fiap.challenge.application.gateway.mesa.CadastrarMesaGateway;
import com.fiap.challenge.application.gateway.restaurante.BuscarRestauranteGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.usecase.mesa.CadastrarMesaUseCase;

public class CadastrarMesaUseCaseImpl implements CadastrarMesaUseCase {

    private final CadastrarMesaGateway cadastrarMesa;

    private final BuscarRestauranteGateway buscarRestaurante;


    public CadastrarMesaUseCaseImpl(CadastrarMesaGateway gateway, BuscarRestauranteGateway buscarRestaurante) {
        this.cadastrarMesa = gateway;
        this.buscarRestaurante = buscarRestaurante;
    }

    @Override
    public Mesa cadastrar(Mesa mesa) {

        //Verifica se o restaurante existe
        buscarRestaurante.findById(mesa.getIdRestaurante()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));


        return cadastrarMesa.cadastrar(mesa);
    }
}
