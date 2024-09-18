package com.fiap.challenge.infrastructure.service.mesa;

import com.fiap.challenge.application.gateway.mesa.CadastrarMesaGateway;
import com.fiap.challenge.core.model.Mesa;
import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import com.fiap.challenge.infrastructure.mapper.mesa.MesaMapper;
import com.fiap.challenge.infrastructure.repository.mesa.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarMesaGatewayImp implements CadastrarMesaGateway {

    private final MesaRepository repository;

    @Override
    public Mesa cadastrar(Mesa mesa) {

        MesaEntity mesaEntity = MesaMapper.INSTANCE.mesaToMesaEntity(mesa);


        return MesaMapper.INSTANCE.mesaEntityToMesa(repository.save(mesaEntity));
    }
}
