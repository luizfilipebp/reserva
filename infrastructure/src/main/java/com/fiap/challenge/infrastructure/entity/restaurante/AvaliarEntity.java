package com.fiap.challenge.infrastructure.entity.restaurante;


import com.fiap.challenge.core.model.enums.TipoAvaliacao;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AVALIACOES")
public class AvaliarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AVA_ID")
    private long id;

    @Column(name = "AVA_IDREST")
    private Long idRestauranteAvaliacao;

    @Column(name = "AVA_TIPOAVA")
    private TipoAvaliacao avaliacao;

    @Column(name = "AVA_COMENTARIO")
    private String comentario;
}

