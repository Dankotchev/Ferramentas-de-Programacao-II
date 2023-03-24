package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Funcionario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class FuncionarioController implements Serializable{

    private List<Funcionario> listaFuncionario = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 1; i < 51; i++) {
            Funcionario criar = new Funcionario("Funcionário " + i, 1000.00 + (25 * i));
            this.listaFuncionario.add(criar);
        }
    }
    
    //
    public FuncionarioController() {
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
}
