package com.fiap.challenge.infrastructure.service.mesa;

import com.fiap.challenge.application.gateway.mesa.AtualizarStatusMesaGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import com.fiap.challenge.infrastructure.repository.mesa.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarStatusMesaGatewayImpl implements AtualizarStatusMesaGateway {
    private final MesaRepository repository;

    @Override
    public Mesa atualizarStatus(Mesa mesa) {
        return MesaMapper.INSTANCE.mesaEntityToMesa(repository.save(MesaMapper.INSTANCE.mesaToMesaEntity(mesa)));
    }
}
