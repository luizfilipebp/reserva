package com.fiap.challenge.core.model.enums;

public enum Dia {

    DOMINGO("dom", "Domingo"),
    SEGUNDA("seg", "Segunda-Feira"),
    TERCA("ter", "Terça-Feira"),
    QUARTA("qua", "Quarta-Feira"),
    QUINTA("qui", "Quinta-Feira"),
    SEXTA("sex", "Sexta-Feira"),
    SABADO("sab", "Sábado");

    private String codigo;
    private String descricao;

    Dia(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Dia fromDescricao(String nome) throws IllegalArgumentException {
        for (Dia dia : Dia.values()) {
            if (dia.descricao.equalsIgnoreCase(nome)) {
                return dia;
            }
        }
        throw new IllegalArgumentException("Dia inválido: " + nome);
    }

    public static Dia fromCodigo(String codigo) throws IllegalArgumentException {
        for (Dia dia : Dia.values()) {
            if (dia.codigo.equalsIgnoreCase(codigo)) {
                return dia;
            }
        }
        throw new IllegalArgumentException("Código do dia inválido: " + codigo);
    }
}
