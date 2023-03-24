package br.edu.ifsp.pep.model;

public class Calculadora {

    private double numero1;
    private double numero2;
    private String operador;

    public double calcular() throws Exception {
        double resultado = 0.0;
        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "/":
                resultado = numero1 / numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            default:
                throw new AssertionError();
        }
        return resultado;
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

}
