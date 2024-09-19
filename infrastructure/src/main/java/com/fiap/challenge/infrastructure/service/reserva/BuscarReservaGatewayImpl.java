package com.fiap.challenge.infrastructure.service.reserva;

import com.fiap.challenge.application.gateway.reserva.BuscarReservaGateway;
import com.fiap.challenge.core.model.Reserva;
import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import com.fiap.challenge.infrastructure.mapper.reserva.ReservaMapper;
import com.fiap.challenge.infrastructure.repository.reserva.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuscarReservaGatewayImpl implements BuscarReservaGateway {

    private final ReservaRepository repository;

    @Override
    public List<Reserva> findAll(int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .stream()
                .map(ReservaMapper.INSTANCE::reservaEntityToReserva)
                .collect(Collectors.toList());
    }

    @Override
    public Reserva findById(Long id) throws RuntimeException {
        ReservaEntity reserva = repository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return ReservaMapper.INSTANCE.reservaEntityToReserva(reserva);
    }

    @Override
    public List<Reserva> findByDataHora(LocalDateTime dataHora) {
        return repository.findByDataHora(dataHora).stream()
                .map(ReservaMapper.INSTANCE::reservaEntityToReserva)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> findByIdUsuario(String idUsuario) {
        return repository.findByIdUsuario(idUsuario).stream()
                .map(ReservaMapper.INSTANCE::reservaEntityToReserva)
                .collect(Collectors.toList());
    }
}
