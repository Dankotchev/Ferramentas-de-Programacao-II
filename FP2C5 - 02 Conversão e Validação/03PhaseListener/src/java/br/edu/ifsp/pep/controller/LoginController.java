package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.service.dao.PessoaDAO;
import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import util.Mensagem;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoa;
    private Pessoa pessoaAutenticada;

    public LoginController() {
        this.pessoa = new Pessoa();
    }

    public void autenticar() {
        this.pessoaAutenticada = pessoaDAO
                .buscarPorLoginSenha(pessoa.getLogin(), pessoa.getSenha());
        if (this.pessoaAutenticada != null)
            Mensagem.info("Usuário autenticado.");
        else {
            Mensagem.error("Login ou Senha inválidos.");
        }
        this.pessoa = new Pessoa();
    }
    
    public boolean verificarTipo1 (){
        if (this.pessoaAutenticada != null 
                && this.pessoaAutenticada.getTipo().equals("1")) 
            return true;
        return false;
    }
    
    //
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaAutenticada() {
        return pessoaAutenticada;
    }
}
