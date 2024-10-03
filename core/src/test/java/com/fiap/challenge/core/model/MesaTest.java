package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusMesa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    @Test
    public void testReservarMesaDisponivel() throws Exception {
        Mesa mesa = new Mesa(1L, 1L, StatusMesa.DISPONIVEL, 4);
        mesa.reservar(2);
        assertEquals(StatusMesa.RESERVADA, mesa.getStatus());
    }

    @Test
    public void testReservarMesaIndisponivel() {
        Mesa mesa = new Mesa(1L, 1L, StatusMesa.INDISPONIVEL, 4);
        Exception exception = assertThrows(Exception.class, () -> mesa.reservar(2));
        assertEquals("Mesa não está disponível para reserva", exception.getMessage());
    }

    @Test
    public void testOcuparMesaDisponivel() {
        Mesa mesa = new Mesa(1L, 1L, StatusMesa.DISPONIVEL, 4);
        mesa.ocupar();
        assertEquals(StatusMesa.OCUPADA, mesa.getStatus());
    }

    @Test
    public void testOcuparMesaIndisponivel() {
        Mesa mesa = new Mesa(1L, 1L, StatusMesa.INDISPONIVEL, 4);
        RuntimeException exception = assertThrows(RuntimeException.class, mesa::ocupar);
        assertEquals("Mesa somente pode ser ocupada se estiver disponível", exception.getMessage());
    }
}