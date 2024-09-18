package com.fiap.challenge.infrastructure.entity.restaurante;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RESTAURANTE")
public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RES_ID")
    private long id;

    @Column(name = "RES_NOME")
    private String nome;

    @Embedded
    private EnderecoEntity localizacao;

    @Column(name = "RES_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoCozinha tipoCozinha;

    @ElementCollection
    @CollectionTable(name = "DIAS_FUNCIONAMENTO", joinColumns = @JoinColumn(name = "DIF_RES_ID"))
    private List<FuncionamentoEntity> diasFuncionamento = new ArrayList<>();;

    @Column(name = "RES_CAPACIDADE")
    private int capacidade;
}
