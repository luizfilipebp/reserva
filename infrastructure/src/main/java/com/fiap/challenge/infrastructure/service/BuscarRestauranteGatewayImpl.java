package com.fiap.challenge.infrastructure.service;

import com.fiap.challenge.application.gateway.BuscarRestauranteGateway;
import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.infrastructure.mapper.RestauranteMapper;
import com.fiap.challenge.infrastructure.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuscarRestauranteGatewayImpl implements BuscarRestauranteGateway {

    RestauranteRepository repository;

    @Override
    @Transactional
    public List<Restaurante> findAll(int size, int page) {
        return repository.findAll(PageRequest.of(size, page)).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Restaurante> findByTipo(TipoCozinha tipo) {
        return repository.findByTipoCozinha(tipo).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<Restaurante> findById(Long idMesa) {
        return Optional.ofNullable(RestauranteMapper.INSTANCE.restauranteEntityToRestaurante(repository.findById(idMesa).orElse(null)));
    }


    @Override
    @Transactional
    public List<Restaurante> findByNome(String nome, int page, int size) {
        return repository.findByNomeContaining(nome, PageRequest.of(page, size)).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Restaurante> findByLogradouro(String logradouro) {
        return repository.findAllByLocalizacao_LogradouroContaining(logradouro).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Restaurante> findByBairro(String bairro) {
        return repository.findAllByLocalizacao_BairroContaining(bairro).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Restaurante> findByCidade(String cidade) {
        return repository.findAllByLocalizacao_CidadeContaining(cidade).stream()
                .map(RestauranteMapper.INSTANCE::restauranteEntityToRestaurante)
                .collect(Collectors.toList());
    }


}
