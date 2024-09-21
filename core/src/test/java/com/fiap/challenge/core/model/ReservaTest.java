package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusReserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        reserva = new Reserva(1L, "1L", 1L, StatusReserva.PENDENTE, LocalDateTime.now().plusDays(1), 1);
    }

    @Test
    void testConfirmarReserva() {
        reserva.confirmarReserva();
        assertEquals(StatusReserva.CONFIRMADA, reserva.getStatus());
    }

    @Test
    void testCancelarReserva() {
        reserva.cancelarReserva();
        assertEquals(StatusReserva.CANCELADA, reserva.getStatus());
    }

    @Test
    void testAlterarDataReserva() {
        LocalDateTime novaData = LocalDateTime.now().plusDays(2);
        reserva.setDataHora(novaData);
        assertEquals(novaData, reserva.getDataHora());
    }

    @Test
    void testAlterarDataReservaInvalida() {
        LocalDateTime novaData = LocalDateTime.now().minusDays(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reserva.setDataHora(novaData));
        assertEquals("Data e hora inválida", exception.getMessage());
    }

    @Test
    void testAlterarQuantidadePessoas() {
        reserva.setQuantidadePessoas(2);
        assertEquals(2, reserva.getQuantidadePessoas());
    }

    @Test
    void testAlterarQuantidadePessoasInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reserva.setQuantidadePessoas(0));
        assertEquals("Quantidade de pessoas inválida", exception.getMessage());
    }
}