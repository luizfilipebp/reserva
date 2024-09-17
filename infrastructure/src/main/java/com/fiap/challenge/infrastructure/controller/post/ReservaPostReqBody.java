package com.fiap.challenge.infrastructure.controller.post;

import com.fiap.challenge.core.model.enums.StatusMesa;

import java.time.LocalDateTime;

public record ReservaPostReqBody(
        String nomeCliente,
        Long idRestaurante,
        LocalDateTime dataHora,
        StatusMesa status,
        int quantidadePessoas
) {
}
