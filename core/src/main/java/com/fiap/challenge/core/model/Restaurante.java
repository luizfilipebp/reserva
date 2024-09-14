package com.fiap.challenge.core.model;

import com.fiap.challenge.core.model.enums.TipoCozinha;
import com.fiap.challenge.core.model.valueobject.Endereco;
import com.fiap.challenge.core.model.valueobject.Funcionamento;

import java.util.List;

public class Restaurante {
    private long id;
    private String nome;
    private Endereco localizacao;
    private TipoCozinha tipoCozinha;
    private List<Funcionamento> diasFuncionamento;
    private int capacidade;

    public Restaurante(long id, String nome, Endereco localizacao, TipoCozinha tipoCozinha, List<Funcionamento> diasFuncionamento, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.diasFuncionamento = diasFuncionamento;
        this.capacidade = capacidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Endereco localizacao) {
        this.localizacao = localizacao;
    }

    public TipoCozinha getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(TipoCozinha tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }

    public List<Funcionamento> getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(List<Funcionamento> diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
