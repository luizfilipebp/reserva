package com.fiap.challenge.infrastructure.entity;

import com.fiap.challenge.core.model.enums.Dia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "dia", column = @Column(name = "DIF_DIA")),
        @AttributeOverride(name = "horaAbertura", column = @Column(name = "DIF_HORA_ABERTURA")),
        @AttributeOverride(name = "horaFechamento", column = @Column(name = "DIF_HORA_FECHAMENTO"))
})
public class FuncionamentoEntity {

    @Enumerated(EnumType.STRING)
    private Dia dia;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
}
