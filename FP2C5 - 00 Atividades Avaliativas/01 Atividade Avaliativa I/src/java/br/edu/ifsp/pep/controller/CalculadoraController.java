package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Calculadora;
import br.edu.ifsp.pep.util.Util;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class CalculadoraController implements Serializable{

    private Calculadora calculadora = new Calculadora();
    private double resultado;
    
    public void calcular(){
        try {
            this.resultado = this.calculadora.calcular();
        } catch (Exception ex) {
            Util.error("Divisão por zero!");
        }
    }

    //
    public CalculadoraController() {
    }

    public CalculadoraController(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public Calculadora getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

}
