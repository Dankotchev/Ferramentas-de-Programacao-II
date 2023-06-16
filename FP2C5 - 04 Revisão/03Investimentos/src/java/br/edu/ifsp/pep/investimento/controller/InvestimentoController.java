package br.edu.ifsp.pep.investimento.controller;

import br.edu.ifsp.pep.investimento.dao.InvestimentoDAO;
import br.edu.ifsp.pep.investimento.model.Investimento;
import br.edu.ifsp.pep.investimento.services.CarteiraInvestimento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class InvestimentoController implements Serializable {

    private Investimento investimento = new Investimento();
    private CarteiraInvestimento carteiraInvestimento = new CarteiraInvestimento();
    
    @Inject
    private InvestimentoDAO investimentoDAO = new InvestimentoDAO();

    public void cadastrarInvestimento() {

        calcularRendimento();

        if (investimento.getTipo().equalsIgnoreCase("CDB")) {
            calcularIR();
            investimento.setRendimentoLíquido(
                    investimento.getRendimentoBruto() - investimento.getIr());
        } else
            investimento.setRendimentoLíquido(investimento.getRendimentoBruto());

        System.out.println(investimento);
        investimentoDAO.insert(investimento);
    }

    private void calcularRendimento() {
        System.out.println("Calclular rendimento");
        double jurosDiario;
        double jurosAnual = (investimento.getPorcentagem() / 100) + 1;
        double rendimento;
        jurosDiario = Math.pow(jurosAnual, ((double)1/365));

        rendimento = investimento.getValorInvestido()
                * Math.pow(jurosDiario, investimento.getTempoInvestido());
        
        investimento.setRendimentoBruto(investimento.getValorInvestido() - rendimento);
    }

    private void calcularIR() {
        Integer tempo = investimento.getTempoInvestido();
        double rendimento = investimento.getRendimentoBruto();
        double ir;
        if (tempo <= 180)
            ir = rendimento * 0.225;
        else if (tempo <= 360)
            ir = rendimento * 0.200;
        else if (tempo <= 720)
            ir = rendimento * 0.175;
        else
            ir = rendimento * 0.150;
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
        carteiraInvestimento.setCarteira(investimentoDAO.findAll());
        return carteiraInvestimento;
    }

    public void setCarteiraInvestimento(CarteiraInvestimento carteiraInvestimento) {
        this.carteiraInvestimento = carteiraInvestimento;
    }
}
