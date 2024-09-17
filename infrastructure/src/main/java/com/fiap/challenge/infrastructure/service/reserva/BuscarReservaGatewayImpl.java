package com.fiap.challenge.infrastructure.service.reserva;

import com.fiap.challenge.application.gateway.BuscarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.mapper.ResevaMapper;
import com.fiap.challenge.infrastructure.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuscarReservaGatewayImpl implements BuscarReservaGateway {

    ReservaRepository repository;

    @Override
    public List<Reserva> findByDataHora(LocalDateTime dataHora) {
        return repository.findByDataHora(dataHora).stream()
                .map(ResevaMapper.INSTANCE::reservaEntityToReserva)
                .collect(Collectors.toList());
    }

}
