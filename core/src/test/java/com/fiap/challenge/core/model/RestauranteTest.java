package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.Estado;
import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.core.model.valueobject.Funcionamento;
import com.fiap.challenge.core.model.enums.Dia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {
    private Restaurante restaurante;
    private Endereco endereco;
    private List<Funcionamento> diasFuncionamento;

    @BeforeEach
    void setUp() {
        endereco = new Endereco("Rua Exemplo", "123", "Bairro", Estado.DF, "12345-678");
        diasFuncionamento = List.of(
                new Funcionamento(Dia.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0)),
                new Funcionamento(Dia.TERCA, LocalTime.of(9, 0), LocalTime.of(18, 0))
        );
        restaurante = new Restaurante(1L, "Restaurante Exemplo", endereco, TipoCozinha.ITALIANA, diasFuncionamento, 50);
    }

    @Test
    void testValidarLocalizacao() {
        assertEquals(endereco, restaurante.getLocalizacao());
    }

    @Test
    void testValidarDiasFuncionamento() {
        assertEquals(diasFuncionamento, restaurante.getDiasFuncionamento());
    }

    @Test
    void testValidarCapacidade() {
        assertEquals(50, restaurante.getCapacidade());
    }

    @Test
    void testSetNome() {
        restaurante.setNome("Novo Nome");
        assertEquals("Novo Nome", restaurante.getNome());
    }

    @Test
    void testSetLocalizacao() {
        Endereco novoEndereco = new Endereco("Rua Nova", "Novo Bairro", "cidade",  Estado.AC, "87654-321");
        restaurante.setLocalizacao(novoEndereco);
        assertEquals(novoEndereco, restaurante.getLocalizacao());
    }

    @Test
    void testSetDiasFuncionamento() {
        List<Funcionamento> novosDiasFuncionamento = List.of(
                new Funcionamento(Dia.QUARTA, LocalTime.of(10, 0), LocalTime.of(20, 0))
        );
        restaurante.setDiasFuncionamento(novosDiasFuncionamento);
        assertEquals(novosDiasFuncionamento, restaurante.getDiasFuncionamento());
    }

    @Test
    void testSetCapacidade() {
        restaurante.setCapacidade(100);
        assertEquals(100, restaurante.getCapacidade());
    }

    @Test
    void testValidarLocalizacaoInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> restaurante.setLocalizacao(null));
        assertEquals("Localização inválida", exception.getMessage());
    }

    @Test
    void testValidarDiasFuncionamentoInvalidos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> restaurante.setDiasFuncionamento(null));
        assertEquals("Dias de funcionamento inválidos", exception.getMessage());
    }

    @Test
    void testValidarCapacidadeInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> restaurante.setCapacidade(0));
        assertEquals("Capacidade inválida", exception.getMessage());
    }
}