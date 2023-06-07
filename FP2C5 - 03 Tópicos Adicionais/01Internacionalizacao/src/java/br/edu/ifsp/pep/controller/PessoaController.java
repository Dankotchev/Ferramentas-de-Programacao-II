package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import br.edu.ifsp.pep.service.dao.PessoaDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import util.Mensagem;

@Named
@SessionScoped
public class PessoaController implements Serializable{

    @Inject
    @EJB
    private PessoaDAO pessoaDAO;

    private List<Pessoa> listaPessoa;
    private Pessoa pessoaSelecionada;
    private Pessoa pessoaInserir = new Pessoa();

    public void cadastrarPessoa() {
        this.pessoaDAO.inserir(pessoaInserir);
        this.pessoaInserir = new Pessoa();
        this.listaPessoa = null;   // Para atualizar a lista de pessoas
        Mensagem.info("Pessoa cadastrado");
    }

    public String alterarPessoa() {
        this.pessoaDAO.atualizar(pessoaSelecionada);
        this.pessoaSelecionada = null;
        return "/pessoa/lista";
    }

    public void removerPessoa() {
        this.pessoaDAO.remover(pessoaSelecionada);
        this.pessoaSelecionada = null;
        this.listaPessoa = null;   // Para atualizar a lista de pessoas
        Mensagem.info("Pessoa removido");
    }

    public List<Pessoa> getListaPessoa() {
        // Reduzi o acesso ao banco de dados
        if (listaPessoa == null) {
            listaPessoa = pessoaDAO.buscarTodos();
        }
        return listaPessoa;
    }
    
    //
    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public Pessoa getPessoaInserir() {
        return pessoaInserir;
    }

    public void setPessoaInserir(Pessoa pessoaInserir) {
        this.pessoaInserir = pessoaInserir;
    }

    public void setListaPessoa(List<Pessoa> listaPessoa) {
        this.listaPessoa = listaPessoa;
    }
}
