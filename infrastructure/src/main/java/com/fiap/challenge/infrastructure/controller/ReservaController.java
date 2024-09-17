package com.fiap.challenge.infrastructure.controller;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.controller.post.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.mapper.ResevaMapper;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reserva")
@AllArgsConstructor
@Tag(name = "Reserva", description = "Endpoints para manipulação de reservas")
public class ReservaController {

    CadastrarReservaUseCase cadastrarReserva;

    @PostMapping
    @Operation(
            summary = "Criar uma reserva",
            description = "Endpoint responsável por criar uma nova reserva"
    )
    public ResponseEntity<Reserva> criar(@RequestBody ReservaPostReqBody req) {

        Reserva reserva = ResevaMapper.INSTANCE.reservaPostReqBodyToReserva(req);

        return ResponseEntity.ok().body(cadastrarReserva.cadastrar(reserva));
    }
}
