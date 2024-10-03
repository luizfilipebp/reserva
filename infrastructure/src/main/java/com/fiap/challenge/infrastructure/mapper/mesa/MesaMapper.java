package com.fiap.challenge.infrastructure.mapper.mesa;

import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.dto.mesa.MesaPostReqBody;
import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MesaMapper {
    MesaMapper INSTANCE = Mappers.getMapper(MesaMapper.class);

    MesaEntity mesaPostReqBodyToMesaEntity(MesaPostReqBody mesaPostReqBody);

    Mesa mesaEntityToMesa(MesaEntity mesaEntity);

    MesaEntity mesaToMesaEntity(Mesa mesa);
}
