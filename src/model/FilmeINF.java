/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

public class FilmeINF {

    private int filmeId;
    private String nome;
    private String sinopse;
    private String dataLancamento;
    private String duracao;
    private String classificacao;
    private BigDecimal valorAluguel;
    private String capaMenor;
    private String capaOriginal;

    public FilmeINF() {

    }

    public FilmeINF(int filmeId, String nome, String sinopse, String dataLancamento, String duracao, String classificacao, BigDecimal valorAluguel, String capaMenor, String capaOriginal) {
        this.filmeId = filmeId;
        this.nome = nome;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.valorAluguel = valorAluguel;
        this.capaMenor = capaMenor;
        this.capaOriginal = capaOriginal;
    }

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = Preferencias.pathImagens + classificacao;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getCapaMenor() {
        return capaMenor;
    }

    public void setCapaMenor(String capaMenor) {
        this.capaMenor = Preferencias.pathImagens + capaMenor;
    }

    public String getCapaOriginal() {
        return capaOriginal;
    }

    public void setCapaOriginal(String capaOriginal) {
        this.capaOriginal = Preferencias.pathImagens + capaOriginal;
    }

}
