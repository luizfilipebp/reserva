package com.fiap.challenge.infrastructure.controller.mesa;

import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.dto.mesa.MesaPostReqBody;
import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import com.fiap.challenge.usecase.mesa.CadastrarMesaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mesa")
@AllArgsConstructor
@Tag(name = "Mesa", description = "Endpoint para manipulação das mesas")
public class MesaController {

    CadastrarMesaUseCase cadastrarMesa;

    @PostMapping
    @Operation(summary = "Criar uma mesa", description = "Endpoint responsável por criar uma nova mesa para um restaurante")
    public ResponseEntity<Mesa> criar(@RequestBody MesaPostReqBody req) {
        MesaEntity mesaEntity = MesaMapper.INSTANCE.mesaPostReqBodyToMesaEntity(req);

        return ResponseEntity.ok().body(cadastrarMesa.cadastrar(MesaMapper.INSTANCE.mesaEntityToMesa(mesaEntity)));
    }
}
