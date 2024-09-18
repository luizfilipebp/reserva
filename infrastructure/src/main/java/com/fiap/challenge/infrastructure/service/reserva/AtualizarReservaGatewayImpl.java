package com.fiap.challenge.infrastructure.service.reserva;

import com.fiap.challenge.application.gateway.reserva.AtualizarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import com.fiap.challenge.infrastructure.mapper.reserva.ReservaMapper;
import com.fiap.challenge.infrastructure.repository.reserva.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarReservaGatewayImpl implements AtualizarReservaGateway {
    ReservaRepository repository;

    @Override
    public Reserva atualizar(Reserva reserva) {
        ReservaEntity updated = repository.save(ReservaMapper.INSTANCE.reservaToReservaEntity(reserva));

        return ReservaMapper.INSTANCE.reservaEntityToReserva(updated);
    }
}
