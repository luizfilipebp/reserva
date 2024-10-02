package com.fiap.challenge.infrastructure.dto.restaurante;

import com.fiap.challenge.core.model.enums.TipoAvaliacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AvaliarPostReqBody (
    @NotNull
    Long idRestauranteAvaliacao,
    @NotNull
    TipoAvaliacao avaliacao,
    String comentario
) {
}
