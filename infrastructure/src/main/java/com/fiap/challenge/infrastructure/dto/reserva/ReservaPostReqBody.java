package com.fiap.challenge.infrastructure.dto.reserva;

import java.time.LocalDateTime;

public record ReservaPostReqBody(
        String nomeCliente,
        Long idRestaurante,
        LocalDateTime dataHora,
        int quantidadePessoas
) {
}
