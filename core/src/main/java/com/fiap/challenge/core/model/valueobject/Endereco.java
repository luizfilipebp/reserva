package com.fiap.challenge.core.model.valueobject;

import com.fiap.challenge.core.model.enums.Estado;

public record Endereco(
        String logradouro,
        String bairro,
        String cidade,
        Estado estado,
        String cep
) {
}
