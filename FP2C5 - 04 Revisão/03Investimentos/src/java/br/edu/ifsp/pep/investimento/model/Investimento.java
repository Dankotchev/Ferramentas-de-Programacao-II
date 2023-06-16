package br.edu.ifsp.pep.investimento.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "investimento")
public class Investimento {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "tipo", length = 3, nullable = false)
    private String tipo;
    
    @Column(name = "valor_investido", nullable = false, precision = 12, scale = 2)
    private Double valorInvestido;
    
    @Column(name = "porcentagem", nullable = false, precision = 6, scale = 2)
    private Double porcentagem;
    
    @Column(name = "tempo_investido", nullable = false)
    private Integer tempoInvestido;
    
    @Column(name = "ir", nullable = false, precision = 12, scale = 2)
    private Double ir;
    
    @Column(name = "rendimento_bruto", nullable = false, precision = 12, scale = 2)
    private Double rendimentoBruto;
    
    @Column(name = "rendimento_liquido", nullable = false, precision = 12, scale = 2)
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
