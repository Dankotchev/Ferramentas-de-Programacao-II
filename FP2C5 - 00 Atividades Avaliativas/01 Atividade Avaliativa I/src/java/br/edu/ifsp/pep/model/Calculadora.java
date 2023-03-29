package br.edu.ifsp.pep.model;

public class Calculadora {

    private double numero1;
    private double numero2;
    private double resultado;
    private String operador;

    public void calcular() {
        switch (operador) {
            case "+":
                this.resultado = this.numero1 + this.numero2;
                break;
            case "-":
                this.resultado = this.numero1 - this.numero2;
                break;
            case "/":
                this.resultado = this.numero1 / this.numero2;
                break;
            case "*":
                this.resultado = this.numero1 * this.numero2;
                break;
        }
    }

    //
    public Calculadora() {
    }

    public Calculadora(double numero1, double numero2, String operador) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operador;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
