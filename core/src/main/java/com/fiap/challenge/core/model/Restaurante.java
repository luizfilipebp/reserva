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
        this.localizacao = validarLocalizacao(localizacao);
        this.tipoCozinha = tipoCozinha;
        this.diasFuncionamento = validarDiasFuncionamento(diasFuncionamento);
        this.capacidade = validarCapacidade(capacidade);
    }

    private Endereco validarLocalizacao(Endereco localizacao) {
        if (localizacao == null) {
            throw new IllegalArgumentException("Localização inválida");
        }

        return localizacao;
    }

    private List<Funcionamento> validarDiasFuncionamento(List<Funcionamento> diasFuncionamento) {
        if (diasFuncionamento == null || diasFuncionamento.isEmpty()) {
            throw new IllegalArgumentException("Dias de funcionamento inválidos");
        }

        for (Funcionamento funcionamento : diasFuncionamento) {
            if (funcionamento.horaAbertura() == null || funcionamento.horaFechamento() == null) {
                throw new IllegalArgumentException("Horário de abertura ou fechamento inválido");
            }

            if (funcionamento.horaAbertura().isAfter(funcionamento.horaFechamento())) {
                throw new IllegalArgumentException("Horário de abertura maior que horário de fechamento");
            }


            if (funcionamento.horaAbertura() == funcionamento.horaFechamento()) {
                throw new IllegalArgumentException("Horário de abertura igual ao horário de fechamento");
            }
        }

        return diasFuncionamento;
    }

    private int validarCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida");
        }
        return capacidade;
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
        this.localizacao = validarLocalizacao(localizacao);
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
        this.diasFuncionamento = validarDiasFuncionamento(diasFuncionamento);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = validarCapacidade(capacidade);
    }
}
