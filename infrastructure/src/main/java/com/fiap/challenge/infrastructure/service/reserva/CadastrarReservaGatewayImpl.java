package com.fiap.challenge.infrastructure.service.reserva;

import com.fiap.challenge.application.gateway.reserva.CadastrarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import com.fiap.challenge.infrastructure.mapper.restaurante.ResevaMapper;
import com.fiap.challenge.infrastructure.repository.reserva.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarReservaGatewayImpl implements CadastrarReservaGateway {

    ReservaRepository repository;

    @Override
    public Reserva cadastrar(Reserva reserva) {
        ReservaEntity reservaEntity = ResevaMapper.INSTANCE.reservaToReservaEntity(reserva);

        return ResevaMapper.INSTANCE.reservaEntityToReserva(repository.save(reservaEntity));
    }

}
