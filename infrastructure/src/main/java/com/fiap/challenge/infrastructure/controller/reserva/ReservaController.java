package com.fiap.challenge.infrastructure.controller.reserva;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPutReqBody;
import com.fiap.challenge.infrastructure.mapper.reserva.ReservaMapper;
import com.fiap.challenge.usecase.reserva.AtualizarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CancelarReservaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reserva")
@AllArgsConstructor
@Tag(name = "Reserva", description = "Endpoints para manipulação de reservas")
public class ReservaController {

    CadastrarReservaUseCase cadastrarReserva;

    AtualizarReservaUseCase atualizarReserva;

    CancelarReservaUseCase cancelarReserva;

    @PostMapping
    @Operation(
            summary = "Criar uma reserva",
            description = "Endpoint responsável por criar uma nova reserva"
    )
    public ResponseEntity<Reserva> criar(@RequestBody ReservaPostReqBody req) {

        Reserva reserva = ReservaMapper.INSTANCE.reservaPostReqBodyToReserva(req);

        return ResponseEntity.ok().body(cadastrarReserva.cadastrar(reserva));
    }


    @PutMapping
    @Operation(
            summary = "Atualizar uma reserva",
            description = "Endpoint responsável por atualizar uma reserva"
    )
    public ResponseEntity<Reserva> update(@RequestBody ReservaPutReqBody req) {

        Reserva reserva = ReservaMapper.INSTANCE.reservaPutReqBodyToReserva(req);

        return ResponseEntity.ok().body(atualizarReserva.atualizar(reserva));

    }

    @PostMapping("/cancelar/{id}")
    @Operation(
            summary = "Criar uma reserva",
            description = "Endpoint responsável por cancelar uma reserva"
    )
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        cancelarReserva.cancelar(id);
        return ResponseEntity.ok().build();
    }



}
