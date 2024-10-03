package com.fiap.challenge.infrastructure.service.mesa;

import com.fiap.challenge.application.gateway.mesa.BuscarMesaGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import com.fiap.challenge.infrastructure.repository.mesa.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarMesaGatewayImpl implements BuscarMesaGateway {

    private final MesaRepository repository;

    @Override
    public Optional<Mesa> buscarPeloId(Long idMesa) {
        return repository.findById(idMesa).map(MesaMapper.INSTANCE::mesaEntityToMesa);
    }
}
