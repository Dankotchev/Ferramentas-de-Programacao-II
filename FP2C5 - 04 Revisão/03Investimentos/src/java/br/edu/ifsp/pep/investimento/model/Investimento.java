package br.edu.ifsp.pep.investimento.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "investimento")
public class Investimento implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo", length = 3, nullable = false)
    private String tipo;

    @Column(name = "valor_investido", nullable = false, precision = 12, scale = 2)
    private double valorInvestido;

    @Column(name = "porcentagem", nullable = false, precision = 6, scale = 2)
    private double porcentagem;

    @Column(name = "tempo_investido", nullable = false)
    private Integer tempoInvestido;

    @Column(name = "ir", nullable = false, precision = 12, scale = 2)
    private double ir;

    @Column(name = "montante", nullable = false, precision = 12, scale = 2)
    private double montante;

    @Column(name = "rendimento_bruto", nullable = false, precision = 12, scale = 2)
    private double rendimentoBruto;

    @Column(name = "rendimento_liquido", nullable = false, precision = 12, scale = 2)
    private double rendimentoLíquido;

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

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Integer getTempoInvestido() {
        return tempoInvestido;
    }

    public void setTempoInvestido(Integer tempoInvestido) {
        this.tempoInvestido = tempoInvestido;
    }

    public double getIr() {
        return ir;
    }

    public void setIr(double ir) {
        this.ir = ir;
    }

    public double getMontante() {
        return rendimentoBruto;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public double getRendimentoBruto() {
        return rendimentoBruto;
    }

    public void setRendimentoBruto(double rendimentoBruto) {
        this.rendimentoBruto = rendimentoBruto;
    }

    public double getRendimentoLíquido() {
        return rendimentoLíquido;
    }

    public void setRendimentoLíquido(double rendimentoLíquido) {
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

    @Override
    public String toString() {
        return "Investimento{" + "id=" + id + ", tipo=" + tipo + ", valorInvestido=" + valorInvestido + ", porcentagem=" + porcentagem + ", tempoInvestido=" + tempoInvestido + ", ir=" + ir + ", montante=" + montante + ", rendimentoBruto=" + rendimentoBruto + ", rendimentoL\u00edquido=" + rendimentoLíquido + '}';
    }
}
