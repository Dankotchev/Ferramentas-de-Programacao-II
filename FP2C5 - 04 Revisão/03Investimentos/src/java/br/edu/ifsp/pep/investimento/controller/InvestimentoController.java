package br.edu.ifsp.pep.investimento.controller;

import br.edu.ifsp.pep.investimento.model.Investimento;
import br.edu.ifsp.pep.investimento.services.CarteiraInvestimento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class InvestimentoController implements Serializable {

    private Investimento investimento = new Investimento();
    private CarteiraInvestimento carteiraInvestimento = new CarteiraInvestimento();

    public void cadastrarInvestimento() {

        calcularRendimento();

        if (investimento.getTipo().equalsIgnoreCase("CDB")) {
            calcularIR();
            investimento.setRendimentoLíquido(
                    investimento.getRendimentoBruto() - investimento.getIr());
        } else {
            investimento.setRendimentoLíquido(investimento.getRendimentoBruto());
        }

        investimento.setId(carteiraInvestimento.getCarteira().size() + 1);
        carteiraInvestimento.adicionarInvestimento(investimento);

    }

    private void calcularRendimento() {
        Double jurosDiario;
        Double jurosAnual = investimento.getPorcentagem() / 100;
        jurosDiario = Math.pow((jurosAnual + 1), (1 / 365)) - 1;

        investimento.setRendimentoBruto(
                investimento.getValorInvestido()
                * Math.pow(jurosDiario + 1, investimento.getTempoInvestido()));
    }

    private void calcularIR() {
        Integer tempo = investimento.getTempoInvestido();
        Double rendimento = investimento.getRendimentoBruto();
        Double ir;
        if (tempo <= 180) {
            ir = rendimento * 0.225;
        } else if (tempo <= 360) {
            ir = rendimento * 0.200;
        } else if (tempo <= 720) {
            ir = rendimento * 0.175;
        } else {
            ir = rendimento * 0.150;
        }
        investimento.setIr(ir);
    }
    
    //
    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public CarteiraInvestimento getCarteiraInvestimento() {
        return carteiraInvestimento;
    }

    public void setCarteiraInvestimento(CarteiraInvestimento carteiraInvestimento) {
        this.carteiraInvestimento = carteiraInvestimento;
    }
}
