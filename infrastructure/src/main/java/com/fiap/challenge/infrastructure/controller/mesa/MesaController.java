package com.fiap.challenge.infrastructure.controller.mesa;

import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.dto.mesa.MesaPostReqBody;
import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import com.fiap.challenge.usecase.mesa.AtualizarStatusMesaUseCase;
import com.fiap.challenge.usecase.mesa.BuscarMesaUseCase;
import com.fiap.challenge.usecase.mesa.CadastrarMesaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mesa")
@AllArgsConstructor
@Tag(name = "Mesa", description = "Endpoint para manipulação das mesas")
public class MesaController {

    private final CadastrarMesaUseCase cadastrarMesa;
    private final BuscarMesaUseCase buscarMesa;
    private final AtualizarStatusMesaUseCase atualizarStatusMesa;

    @PostMapping
    @Operation(summary = "Criar uma mesa", description = "Endpoint responsável por criar uma nova mesa para um restaurante")
    public ResponseEntity<Mesa> criar(@RequestBody MesaPostReqBody req) {
        MesaEntity mesaEntity = MesaMapper.INSTANCE.mesaPostReqBodyToMesaEntity(req);

        return ResponseEntity.ok().body(cadastrarMesa.cadastrar(MesaMapper.INSTANCE.mesaEntityToMesa(mesaEntity)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma mesa", description = "Endpoint responsável por buscar uma mesa pelo seu id")
    public ResponseEntity<Mesa> buscar(@PathVariable Long id) {
        return ResponseEntity.ok().body(buscarMesa.buscarPeloId(id));
    }


    @PostMapping("/disponibilizar/{id}")
    @Operation(summary = "Disponibilizar uma mesa", description = "Endpoint responsável por disponibilizar uma mesa")
    public ResponseEntity<Mesa> disponibilizar(@PathVariable Long id) {
        return ResponseEntity.ok().body(atualizarStatusMesa.disponibilizarMesa(id));
    }

    @PostMapping("/ocupar/{id}")
    @Operation(summary = "Ocupar uma mesa", description = "Endpoint responsável por ocupar uma mesa")
    public ResponseEntity<Mesa> ocupar(@PathVariable Long id) {
        return ResponseEntity.ok().body(atualizarStatusMesa.ocuparMesa(id));
    }

    @PostMapping("/limpar/{id}")
    @Operation(summary = "Limpar uma mesa", description = "Endpoint responsável por limpar uma mesa")
    public ResponseEntity<Mesa> limpar(@PathVariable Long id) {
        return ResponseEntity.ok().body(atualizarStatusMesa.limparMesa(id));
    }

    @PostMapping("/indisponibilizar/{id}")
    @Operation(summary = "Indisponibilizar uma mesa", description = "Endpoint responsável por indisponibilizar uma mesa")
    public ResponseEntity<Mesa> indisponibilizar(@PathVariable Long id) {
        return ResponseEntity.ok().body(atualizarStatusMesa.indisponibilizarMesa(id));
    }

}
