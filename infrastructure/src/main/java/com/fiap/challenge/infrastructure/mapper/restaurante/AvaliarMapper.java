package com.fiap.challenge.infrastructure.mapper.restaurante;

import com.fiap.challenge.core.model.Avaliar;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.dto.mesa.MesaPostReqBody;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.dto.restaurante.AvaliarPostReqBody;
import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import com.fiap.challenge.infrastructure.entity.restaurante.AvaliarEntity;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvaliarMapper {
    AvaliarMapper INSTANCE = Mappers.getMapper(AvaliarMapper.class);

    Avaliar avaliarEntityToAvaliar(AvaliarEntity avaliarEntity);

    Avaliar avaliarPostReqBodyToAvaliar(AvaliarPostReqBody avaliarPostReqBody);
    AvaliarEntity avaliarToAvaliarEntity(Avaliar avaliar);

}
