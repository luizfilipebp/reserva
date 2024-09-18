package com.fiap.challenge.infrastructure.repository.restaurante;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.infrastructure.entity.restaurante.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
    Page<RestauranteEntity> findByNomeContaining(String nome, Pageable pegeable);
    List<RestauranteEntity> findAllByLocalizacao_LogradouroContaining(String logradouro);
    List<RestauranteEntity> findAllByLocalizacao_BairroContaining(String logradouro);
    List<RestauranteEntity> findAllByLocalizacao_CidadeContaining(String logradouro);
    List<RestauranteEntity> findByTipoCozinha(TipoCozinha tipoCozinha);
}
