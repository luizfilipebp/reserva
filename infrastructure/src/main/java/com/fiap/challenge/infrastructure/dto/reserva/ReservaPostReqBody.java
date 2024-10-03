package com.fiap.challenge.infrastructure.dto.reserva;

import java.time.LocalDateTime;

public record ReservaPostReqBody(
        String idUsuario,
        Long idRestaurante,
        LocalDateTime dataHora,
        int quantidadePessoas
) {
}
