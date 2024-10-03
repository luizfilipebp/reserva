package com.fiap.challenge.infrastructure.service.restaurante;

import com.fiap.challenge.application.gateway.restaurante.AvaliarRestauranteGateway;
import com.fiap.challenge.core.model.Avaliar;
import com.fiap.challenge.infrastructure.entity.restaurante.AvaliarEntity;
import com.fiap.challenge.infrastructure.mapper.restaurante.AvaliarMapper;
import com.fiap.challenge.infrastructure.repository.restaurante.AvaliarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AvaliarRestauranteGatewayImpl implements AvaliarRestauranteGateway {

    private final AvaliarRepository repository;
    @Override
    public Avaliar avaliar(Avaliar avaliar) {
        AvaliarEntity avaliarEntity = AvaliarMapper.INSTANCE.avaliarToAvaliarEntity(avaliar);
        AvaliarEntity save = repository.save(avaliarEntity);
        return AvaliarMapper.INSTANCE.avaliarEntityToAvaliar(save);
    }

    @Override
    public Optional<Avaliar> buscarAvaliacao(Long id) {
        return repository.findById(id).map(AvaliarMapper.INSTANCE::avaliarEntityToAvaliar);
    }

    @Override
    public List<Avaliar> buscarAvaliacaoTodos(int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .stream()
                .map(AvaliarMapper.INSTANCE::avaliarEntityToAvaliar)
                .collect(Collectors.toList());
    }
}
