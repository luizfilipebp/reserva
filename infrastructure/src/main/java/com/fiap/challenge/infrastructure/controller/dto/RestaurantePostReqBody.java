package com.fiap.challenge.infrastructure.controller.dto;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.core.model.valueobject.Funcionamento;

import java.util.List;

public record RestaurantePostReqBody(
        long id,
        String nome,
        Endereco localizacao,
        TipoCozinha tipoCozinha,
        List<Funcionamento> diasFuncionamento,
        int capacidade
) {
}
