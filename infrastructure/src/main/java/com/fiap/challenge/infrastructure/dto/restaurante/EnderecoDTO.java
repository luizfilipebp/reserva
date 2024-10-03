package com.fiap.challenge.infrastructure.dto.restaurante;

import io.swagger.v3.oas.annotations.media.Schema;

public record EnderecoDTO(
        @Schema(type = "string", example = "Rua Isaura Parente, 358") String logradouro,
        @Schema(type = "string", example = "Bosque") String bairro,
        @Schema(type = "string", example = "Rio Branco") String cidade,
        @Schema(type = "string", example = "AC") String estado,
        @Schema(type = "string", example = "69900-472") String cep
) {
}