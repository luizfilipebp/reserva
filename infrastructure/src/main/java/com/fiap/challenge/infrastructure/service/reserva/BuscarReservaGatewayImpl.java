package com.fiap.challenge.infrastructure.service.reserva;

import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.mapper.reserva.ReservaMapper;
import com.fiap.challenge.infrastructure.repository.reserva.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuscarReservaGatewayImpl implements BuscarReservaGateway {

    ReservaRepository repository;

    @Override
    public Optional<Reserva> findById(Long id) {
        return repository.findById(id)
                .map(ReservaMapper.INSTANCE::reservaEntityToReserva);
    }

    @Override
    public List<Reserva> findByDataHora(LocalDateTime dataHora) {
        return repository.findByDataHora(dataHora).stream()
                .map(ReservaMapper.INSTANCE::reservaEntityToReserva)
                .collect(Collectors.toList());
    }

}
