package com.alvesdev.Desafio.Cnab.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TB_Transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Tipo de transação, natureza da transação e sinal (+ ou -)
    private String descricao;
    private String natureza;
    private String sinal;
    //Informações gerais
    private LocalDate data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private LocalTime hora;

    private String donoLoja;
    private String nomeLoja;

    public Transacao(Long id, String descricao, String natureza, String sinal, LocalDate data, BigDecimal valor, String cpf, String cartao, LocalTime hora, String donoLoja, String nomeLoja) {
        this.id = id;
        this.descricao = descricao;
        this.natureza = natureza;
        this.sinal = sinal;
        this.data = data;
        this.valor = valor;
        this.cpf = cpf;
        this.cartao = cartao;
        this.hora = hora;
        this.donoLoja = donoLoja;
        this.nomeLoja = nomeLoja;
    }

    public Transacao() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDonoLoja() {
        return donoLoja;
    }

    public void setDonoLoja(String donoLoja) {
        this.donoLoja = donoLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
