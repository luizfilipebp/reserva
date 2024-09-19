package com.fiap.challenge.usecase.reserva;

import com.fiap.challenge.core.model.Reserva;

import java.util.List;

public interface BuscarReservaUseCase {
    List<Reserva> buscarTodos(int page, int size);
    Reserva buscarPorId(Long idReserva);
    List<Reserva> buscarPeloIdUsuario(String idUsuario);

}
