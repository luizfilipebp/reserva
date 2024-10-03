package com.fiap.challenge.usecase.restaurante;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;

import java.util.List;

public interface BuscarRestauranteUseCase {

    List<Restaurante> buscarTodos(int size, int page);

    List<Restaurante> buscarPorNome(String nome, int size, int page);

    List<Restaurante> buscarPorLocalizacao(Endereco localizacao);

    List<Restaurante> buscarPorTipoDeCozinha(TipoCozinha tipoDeCozinha);
}
