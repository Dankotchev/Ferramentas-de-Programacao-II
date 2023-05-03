package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculadoraController {

    private Double valorA;
    private Double valorB;
    private Double resultado;
    private String nome;

    public void somar() {
        this.resultado = this.valorA + this.valorB;
    }

    //
    public Double getValorA() {
        return valorA;
    }

    public void setValorA(Double valorA) {
        this.valorA = valorA;
    }

    public Double getValorB() {
        return valorB;
    }

    public void setValorB(Double valorB) {
        this.valorB = valorB;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
