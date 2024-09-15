package com.fiap.challenge.infrastructure.controller.dto;

import com.fiap.challenge.core.model.enums.Dia;
import io.swagger.v3.oas.annotations.media.Schema;

public record FuncionamentoDTO(
        Dia dia,
        @Schema(type = "string", format = "time", example = "12:00:00") String horaAbertura,
        @Schema(type = "string", format = "time", example = "18:00:00") String horaFechamento
) {
}