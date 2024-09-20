package com.fiap.challenge.usecase.mesa;

import com.fiap.challenge.core.model.Mesa;

public interface AtualizarStatusMesaUseCase {
    Mesa disponibilizarMesa(Long idMesa);
    Mesa ocuparMesa(Long idMesa);
    Mesa reservarMesa(Long idMesa);
    Mesa limparMesa(Long idMesa);
    Mesa indisponibilizarMesa(Long idMesa);
}
