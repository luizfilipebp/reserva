package com.fiap.challenge.infrastructure.mapper.reserva;


import com.fiap.challenge.core.model.valueobject.Funcionamento;
import com.fiap.challenge.infrastructure.entity.repositorio.FuncionamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionamentoMapper {
    FuncionamentoMapper INSTANCE = Mappers.getMapper(FuncionamentoMapper.class);

    Funcionamento funcionamentoEntityToFuncionamento(FuncionamentoEntity funcionamento);

    FuncionamentoEntity funcionamentoToFuncionamentoEntity(Funcionamento funcionamento);

}
