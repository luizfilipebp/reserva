package com.fiap.challenge.application.gateway;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.TipoCozinha;

import java.util.List;

public interface BuscarRestauranteGateway {

    List<Restaurante> findAll(int size, int page);

    List<Restaurante> findByNome(String nome, int size, int page);

    List<Restaurante> findByLogradouro(String logradouro);

    List<Restaurante> findByBairro(String bairro);

    List<Restaurante> findByCidade(String cidade);

    List<Restaurante> findByTipo(TipoCozinha tipo);
}
