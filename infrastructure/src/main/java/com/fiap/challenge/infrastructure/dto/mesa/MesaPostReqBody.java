package com.fiap.challenge.infrastructure.dto.mesa;

import io.swagger.v3.oas.annotations.media.Schema;

public record MesaPostReqBody(
        @Schema(type = "long", example = "1") long idRestaurante,
        @Schema(type = "integer", example = "4") int capacidade
) {
}
