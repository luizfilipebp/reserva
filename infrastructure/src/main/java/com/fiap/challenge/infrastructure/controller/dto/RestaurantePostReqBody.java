package com.fiap.challenge.infrastructure.controller.dto;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;

import java.util.List;

public record RestaurantePostReqBody(
        String nome,
        Endereco localizacao,
        TipoCozinha tipoCozinha,
        List<FuncionamentoDTO> diasFuncionamento,
        int capacidade
) {
}
