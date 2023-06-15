package br.edu.ifsp.pep.investimento.model;

import java.util.Objects;

public class Investimento {
    private Integer id;
    private String tipo;
    private Double valorInvestido;
    private Double porcentagem;
    private Integer tempoInvestido;
    private Double ir;
    private Double rendimentoBruto;
    private Double rendimentoLíquido;

    
    //
    public Investimento() {
        this.ir = 0.0;
        this.rendimentoBruto = 0.0;
        this.rendimentoLíquido = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Integer getTempoInvestido() {
        return tempoInvestido;
    }

    public void setTempoInvestido(Integer tempoInvestido) {
        this.tempoInvestido = tempoInvestido;
    }

    public Double getIr() {
        return ir;
    }

    public void setIr(Double ir) {
        this.ir = ir;
    }

    public Double getRendimentoBruto() {
        return rendimentoBruto;
    }

    public void setRendimentoBruto(Double rendimentoBruto) {
        this.rendimentoBruto = rendimentoBruto;
    }

    public Double getRendimentoLíquido() {
        return rendimentoLíquido;
    }

    public void setRendimentoLíquido(Double rendimentoLíquido) {
        this.rendimentoLíquido = rendimentoLíquido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Investimento other = (Investimento) obj;
        return Objects.equals(this.id, other.id);
    }
}
