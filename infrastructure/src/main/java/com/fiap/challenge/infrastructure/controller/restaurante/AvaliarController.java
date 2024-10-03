package com.fiap.challenge.infrastructure.controller.restaurante;

import com.fiap.challenge.core.model.Avaliar;
import com.fiap.challenge.infrastructure.dto.restaurante.AvaliarPostReqBody;
import com.fiap.challenge.infrastructure.mapper.restaurante.AvaliarMapper;
import com.fiap.challenge.usecase.restaurante.AvaliarRestauranteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/avaliar")
@AllArgsConstructor
@Tag(name = "Avaliar", description = "Endpoint para manipulação das avaliações")
public class AvaliarController {

    private final AvaliarRestauranteUseCase avaliarRestaurante;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma avaliação", description = "Endpoint responsável por buscar uma avaliação pelo seu id")
    public ResponseEntity<Optional<Avaliar>> buscarAvaliacao(@PathVariable Long id) {
        return ResponseEntity.ok().body(avaliarRestaurante.buscarAvaliacaoPorId(id));
    }

    @GetMapping
    @Operation(
            summary = "Buscar todas avaliações",
            description = "Endpoint responsável por buscar todas avaliações"
    )
    public ResponseEntity<Object> buscarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(avaliarRestaurante.buscarAvaliacaoTodos(page, size));
    }


    @PostMapping
    @Operation(summary = "Avaliar um restaurante", description = "Endpoint responsável por avaliar um restaurante")
    public ResponseEntity<Avaliar> avaliar(@RequestBody AvaliarPostReqBody req) {
            Avaliar avaliar = AvaliarMapper.INSTANCE.avaliarPostReqBodyToAvaliar(req);

            return ResponseEntity.ok().body(avaliarRestaurante.avaliarRestaurante(avaliar));
    }
}
