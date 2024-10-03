package com.fiap.challenge.infrastructure.mapper.restaurante;


import com.fiap.challenge.core.model.valueobject.Funcionamento;
import com.fiap.challenge.infrastructure.entity.restaurante.FuncionamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionamentoMapper {
    FuncionamentoMapper INSTANCE = Mappers.getMapper(FuncionamentoMapper.class);

    Funcionamento funcionamentoEntityToFuncionamento(FuncionamentoEntity funcionamento);

    FuncionamentoEntity funcionamentoToFuncionamentoEntity(Funcionamento funcionamento);

}
