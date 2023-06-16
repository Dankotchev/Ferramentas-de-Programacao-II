package br.edu.ifsp.pep.investimento.services;

import br.edu.ifsp.pep.investimento.model.Investimento;
import java.util.ArrayList;
import java.util.List;

public class CarteiraInvestimento {
    private List<Investimento> carteira;

    public CarteiraInvestimento() {
        this.carteira = new ArrayList<>();
    }
    
    public void adicionarInvestimento (Investimento i) {
        this.carteira.add(i);
    }

    public List<Investimento> getCarteira() {
        return carteira;
    }

    public void setCarteira(List<Investimento> carteira) {
        this.carteira = carteira;
    }
}
