package com.fiap.challenge.infrastructure.dto.restaurante;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record RestaurantePostReqBody(
        @Schema(type = "string", example = "La Cave Bar e Restaurante") String nome,
        EnderecoDTO localizacao,
        TipoCozinha tipoCozinha,
        List<FuncionamentoDTO> diasFuncionamento,
        @Schema(type = "integer", example = "100") int capacidade
) {
}
