package com.fiap.challenge.infrastructure.entity;

import com.fiap.challenge.core.model.enums.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "logradouro", column = @Column(name = "RES_LOGRADOURO")),
        @AttributeOverride(name = "bairro", column = @Column(name = "RES_BAIRRO")),
        @AttributeOverride(name = "cidade", column = @Column(name = "RES_CIDADE")),
        @AttributeOverride(name = "estado", column = @Column(name = "RES_ESTADO")),
        @AttributeOverride(name = "cep", column = @Column(name = "RES_CEP"))
})
public class EnderecoEntity {
    private String logradouro;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String cep;
}
