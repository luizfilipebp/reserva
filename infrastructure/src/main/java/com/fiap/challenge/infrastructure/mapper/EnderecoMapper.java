package com.fiap.challenge.infrastructure.mapper;

import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.infrastructure.entity.EnderecoEntity;
import com.fiap.challenge.infrastructure.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    @Mapping(source = "localizacao.logradouro", target = "logradouro")
    @Mapping(source = "localizacao.bairro", target = "bairro")
    @Mapping(source = "localizacao.cidade", target = "cidade")
    @Mapping(source = "localizacao.estado", target = "estado")
    @Mapping(source = "localizacao.cep", target = "cep")
    Endereco enderecoEntityToEndereco(RestauranteEntity restaurante);

    EnderecoEntity enderecoToEnderecoEntity(Endereco endereco);

}
