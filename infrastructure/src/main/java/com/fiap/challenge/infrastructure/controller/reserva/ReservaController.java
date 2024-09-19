package com.fiap.challenge.infrastructure.controller.reserva;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPutReqBody;
import com.fiap.challenge.infrastructure.mapper.reserva.ReservaMapper;
import com.fiap.challenge.usecase.reserva.AtualizarReservaUseCase;
import com.fiap.challenge.usecase.reserva.BuscarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CadastrarReservaUseCase;
import com.fiap.challenge.usecase.reserva.CancelarReservaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reserva")
@AllArgsConstructor
@Tag(name = "Reserva", description = "Endpoints para manipulação de reservas")
public class ReservaController {

    private final BuscarReservaUseCase buscarReserva;
    private final CadastrarReservaUseCase cadastrarReserva;
    private final AtualizarReservaUseCase atualizarReserva;
    private final CancelarReservaUseCase cancelarReserva;

    @GetMapping
    @Operation(
            summary = "Pesquisar reservas",
            description = "Endpoint responsável por buscar todas as reservas"
    )
    public ResponseEntity<List<Reserva>> buscar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(buscarReserva.buscarTodos(page, size));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar uma reserva",
            description = "Endpoint responsável por buscar uma reserva pelo id"
    )
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(buscarReserva.buscarPorId(id));
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(
            summary = "Buscar reservas de um usuário",
            description = "Endpoint responsável por buscar todas as reservas de um usuário"
    )
    public ResponseEntity<List<Reserva>> buscarPorIdUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok().body(buscarReserva.buscarPeloIdUsuario(idUsuario));
    }

    @PostMapping
    @Operation(
            summary = "Criar uma reserva",
            description = "Endpoint responsável por criar uma nova reserva"
    )
    public ResponseEntity<Reserva> criar(@RequestBody ReservaPostReqBody req) {

        Reserva reserva = ReservaMapper.INSTANCE.reservaPostReqBodyToReserva(req);

        return ResponseEntity.ok().body(cadastrarReserva.cadastrar(reserva));
    }

    @PostMapping("/cancelar/{id}")
    @Operation(
            summary = "Cancelar uma reserva",
            description = "Endpoint responsável por cancelar uma reserva"
    )
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        cancelarReserva.cancelar(id);
        return ResponseEntity.ok().build();
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
}
