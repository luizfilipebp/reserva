package com.fiap.challenge.infrastructure.entity.reserva;


import com.fiap.challenge.core.model.enums.StatusMesa;
import com.fiap.challenge.core.model.enums.StatusReserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RSV_ID")
    private long id;

    @Column(name = "RSV_NOME_CLIENTE")
    private String idUsuario;

    @Column(name = "RSV_RES_ID")
    private Long idRestaurante;

    @Column(name = "RSV_DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "RSV_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @Column(name = "RSV_QTD_PESSOAS")
    private int quantidadePessoas;
}
