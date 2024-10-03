package com.fiap.challenge.infrastructure.entity.mesa;

import com.fiap.challenge.core.model.enums.StatusMesa;
import com.fiap.challenge.infrastructure.entity.restaurante.RestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MESA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MES_ID")
    private long id;

    @Column(name = "MES_RES_ID")
    private long idRestaurante;

    @Column(name = "MES_CAPACIDADE")
    private int capacidade;

    @Column(name = "MES_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusMesa status;
}
