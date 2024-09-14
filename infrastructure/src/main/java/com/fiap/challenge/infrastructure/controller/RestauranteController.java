package com.fiap.challenge.infrastructure.controller;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.infrastructure.controller.dto.RestaurantePostReqBody;
import com.fiap.challenge.infrastructure.mapper.RestauranteMapper;
import com.fiap.challenge.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.challenge.usecase.restaurante.CadastrarRestauranteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/restaurante")
@AllArgsConstructor
@Tag(name = "Restaurante", description = "Descrição da RestauranteController")
public class RestauranteController {

    private final BuscarRestauranteUseCase buscarRestaurante;

    private final CadastrarRestauranteUseCase cadastrarRestaurante;

    @GetMapping
    @Operation(
            summary = "Pesquisar restaurantes",
            description = "A pesquisa pode ser realizada pelo nome ou pelo endereco ou pelo tipo de cozinha. Caso nenhum parâmetro for passado irá listar todos"
    )
    public ResponseEntity<List<Restaurante>> searchRestaurants(
            @RequestParam(required = false) String nome,
            @RequestBody(required = false) Endereco localizacao,
            @RequestParam(required = false) TipoCozinha tipoCozinha,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<Restaurante> restaurantes;

        switch (Optional.ofNullable(nome).isPresent() ? "NOME" :
                Optional.ofNullable(localizacao).isPresent() ? "ENDERECO" :
                        Optional.ofNullable(tipoCozinha).isPresent() ? "TIPO_COZINHA" : "DEFAULT") {
            case "NOME" -> restaurantes = buscarRestaurante.buscarPorNome(nome, size, page);
            case "ENDERECO" -> restaurantes = buscarRestaurante.buscarPorLocalizacao(localizacao);
            case "TIPO_COZINHA" -> restaurantes = buscarRestaurante.buscarPorTipoDeCozinha(tipoCozinha);
            default -> restaurantes = buscarRestaurante.buscarTodos(page, size);

        }

        return ResponseEntity.ok().body(restaurantes);
    }


    @PostMapping
    @Operation(
            summary = "Criar um restaurante",
            description = "Endpoint responsável por criar um novo restaurante"
    )
    public ResponseEntity<Restaurante> criar(@RequestBody RestaurantePostReqBody req) {
        Restaurante restaurante = RestauranteMapper.INSTANCE.restaurantePostReqBodyToRestaurante(req);

        return ResponseEntity.ok().body(cadastrarRestaurante.cadastrar(restaurante));
    }
}
