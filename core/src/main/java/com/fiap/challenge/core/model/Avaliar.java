package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.TipoAvaliacao;

public class Avaliar {

    private long id;
    private long  idRestauranteAvaliacao;
    private TipoAvaliacao avaliacao;
    private String comentario;

    public Avaliar(long id, long idRestauranteAvaliacao, TipoAvaliacao avaliacao, String comentario) {
        this.id = id;
        this.idRestauranteAvaliacao = idRestauranteAvaliacao;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public long getId() {
        return id;
    }

    public long getIdRestauranteAvaliacao() {
        return idRestauranteAvaliacao;
    }

    public TipoAvaliacao getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setAvaliacao(TipoAvaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setIdRestauranteAvaliacao(long idRestauranteAvaliacao) {
        this.idRestauranteAvaliacao = idRestauranteAvaliacao;
    }
}
