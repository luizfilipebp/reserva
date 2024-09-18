package com.fiap.challenge.infrastructure.mapper.reserva;

import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPostReqBody;
import com.fiap.challenge.infrastructure.dto.reserva.ReservaPutReqBody;
import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {
    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    Reserva reservaPutReqBodyToReserva(ReservaPutReqBody reservaPutReqBody);
    Reserva reservaPostReqBodyToReserva(ReservaPostReqBody reservaPostReqBody);
    Reserva reservaEntityToReserva(ReservaEntity reservaEntity);
    ReservaEntity reservaToReservaEntity(Reserva reserva);
}
