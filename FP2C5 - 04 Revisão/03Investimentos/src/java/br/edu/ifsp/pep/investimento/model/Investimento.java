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
    private double rendimentoLiquido;

    public void calcularInvestimento() {
        calcularRendimentoBruto();
        
        if (this.tipo.equalsIgnoreCase("CDB")){
            calcularIR();
            this.rendimentoLiquido = this.rendimentoBruto - this.ir;
        }
        else
            this.rendimentoLiquido = this.rendimentoBruto;
        
        calcularMontante();
    }

    private void calcularRendimentoBruto() {
        double jurosDiario;
        double montanteBruto;

        jurosDiario = Math.pow((this.porcentagem / 100) + 1, ((double) 1 / 365));
        montanteBruto = this.valorInvestido * Math.pow(jurosDiario, this.tempoInvestido);
        this.rendimentoBruto = montanteBruto - this.valorInvestido;
    }

    private void calcularIR() {
        if (this.tempoInvestido <= 180)
            this.ir = this.rendimentoBruto * 0.225;
        else if (this.tempoInvestido <= 360)
            this.ir = this.rendimentoBruto * 0.200;
        else if (this.tempoInvestido <= 720)
            this.ir = this.rendimentoBruto * 0.175;
        else
            this.ir = this.rendimentoBruto * 0.150;
    }

    private void calcularMontante() {
        this.montante = this.valorInvestido + this.rendimentoLiquido;
    }

    //
    public Investimento() {
        this.ir = 0.0;
        this.rendimentoBruto = 0.0;
        this.rendimentoLiquido = 0.0;
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
        return montante;
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

    public double getRendimentoLiquido() {
        return rendimentoLiquido;
    }

    public void setRendimentoLiquido(double rendimentoLiquido) {
        this.rendimentoLiquido = rendimentoLiquido;
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
