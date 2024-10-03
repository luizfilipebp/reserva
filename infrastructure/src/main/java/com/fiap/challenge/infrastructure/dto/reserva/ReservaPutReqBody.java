package com.fiap.challenge.infrastructure.dto.reserva;

import java.time.LocalDateTime;

public record ReservaPutReqBody(
        long id,
        LocalDateTime dataHora,
        int quantidadePessoas
) {
}
