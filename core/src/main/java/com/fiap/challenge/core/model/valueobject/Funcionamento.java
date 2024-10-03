package com.fiap.challenge.core.model.valueobject;

import com.fiap.challenge.core.model.enums.Dia;

import java.time.LocalTime;

public record Funcionamento(
        Dia dia,
        LocalTime horaAbertura,
        LocalTime horaFechamento
) {
}
