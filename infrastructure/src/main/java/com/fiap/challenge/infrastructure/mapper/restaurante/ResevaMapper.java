package com.fiap.challenge.infrastructure.mapper.restaurante;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResevaMapper {
    ResevaMapper INSTANCE = Mappers.getMapper(ResevaMapper.class);


    Reserva reservaPostReqBodyToReserva(ReservaPostReqBody reservaPostReqBody);

    Reserva reservaEntityToReserva(ReservaEntity reservaEntity);
    ReservaEntity reservaToReservaEntity(Reserva reserva);
}
