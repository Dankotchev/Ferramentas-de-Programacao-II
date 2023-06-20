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
    private boolean calculado = false;
    
    @Inject
    private InvestimentoDAO investimentoDAO = new InvestimentoDAO();

    public void cadastrarInvestimento() {

        investimento.calcularInvestimento();
        this.calculado = true;
        System.out.println(investimento);
        investimentoDAO.insert(investimento);
    }

    public void novoInvestimento(){
        investimento = new Investimento();
        calculado = false;
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

    public boolean isCalculado() {
        return calculado;
    }

    public void setCalculado(boolean calculado) {
        this.calculado = calculado;
    }
}
