package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.StatusReserva;
import com.fiap.challenge.core.model.enums.TipoAvaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvaliarRestauranteTest {
    private Avaliar avaliar;

    @BeforeEach
    void setUp() {
        avaliar = new Avaliar(1L, 1L, TipoAvaliacao.EXCELENTE, "ADOREI!!" );
    }

    @Test
    void testValidarId() {
        avaliar.setId(1);
        assertEquals(1, avaliar.getId());
    }
    @Test
    void testValidarIdRestaurante() {
        avaliar.setIdRestauranteAvaliacao(5);
        assertEquals(5, avaliar.getIdRestauranteAvaliacao());
    }

    @Test
    void testValidarTipoAvaliacao() {
        avaliar.setAvaliacao(TipoAvaliacao.BOM);
        assertEquals(TipoAvaliacao.BOM, avaliar.getAvaliacao());
    }



    @Test
    void testValidarComentario() {
        avaliar.setComentario("muito excelente");
        assertEquals("muito excelente", avaliar.getComentario());
    }

}
