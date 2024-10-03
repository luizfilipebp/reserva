package com.fiap.challenge.infrastructure.mapper.restaurante;

import com.fiap.challenge.core.model.Restaurante;
import com.fiap.challenge.core.model.valueobject.Funcionamento;
import com.fiap.challenge.infrastructure.dto.restaurante.RestaurantePostReqBody;
import com.fiap.challenge.infrastructure.entity.restaurante.FuncionamentoEntity;
import com.fiap.challenge.infrastructure.entity.restaurante.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = EnderecoMapper.class)
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    Restaurante restauranteEntityToRestaurante(RestauranteEntity restaurante);

    RestauranteEntity restauranteToRestauranteEntity(Restaurante restaurante);

    Restaurante restaurantePostReqBodyToRestaurante(RestaurantePostReqBody restaurantePostReqBody);

    default List<Funcionamento> mapFuncionamentoEntitiesToFuncionamentos(List<FuncionamentoEntity> funcionamentoEntities) {
        if (funcionamentoEntities == null) {
            return null;
        }
        return funcionamentoEntities.stream()
                .map(FuncionamentoMapper.INSTANCE::funcionamentoEntityToFuncionamento)
                .collect(Collectors.toList());
    }

    default List<FuncionamentoEntity> mapFuncionamentoToFuncionamentoEntityList(List<Funcionamento> funcionamentos) {
        if (funcionamentos == null) {
            return null;
        }
        return funcionamentos.stream()
                .map(FuncionamentoMapper.INSTANCE::funcionamentoToFuncionamentoEntity)
                .collect(Collectors.toList());
    }

}
