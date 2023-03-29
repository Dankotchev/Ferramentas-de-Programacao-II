package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Calculadora;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import util.Mensagem;

@Named
@RequestScoped
public class CalculadoraController implements Serializable {

    private Calculadora calculadora = new Calculadora();

    public void calcular() {
        String operador = this.calculadora.getOperador();

        // Validação da divisão por Zero
        if (operador.equals("/")
                && this.calculadora.getNumero2() == 0) {
            Mensagem.error("Divisão por Zero!");
            return;
        }

        // Validação dos operadores válidos
        if (!operador.equals("+")
                && !operador.equals("-")
                && !operador.equals("*")
                && !operador.equals("/")) {
            Mensagem.warn("Informe um operador válido:\n(+, -, *, /)");
            return;
        }

        this.calculadora.calcular();
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
}
