package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import br.edu.ifsp.pep.services.PessoaService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import util.Mensagem;

@Named
@RequestScoped
public class PessoaController implements Serializable {

    @EJB
    private PessoaService pessoaService;
    private Pessoa usuario = new Pessoa();

    public void login() {
        Pessoa login = pessoaService.login(usuario.getLogin(), usuario.getSenha());
        if (login != null)
            Mensagem.info("Seja bem vindo " + login.getNome() + "!");
        else
            Mensagem.error("Login e/ou Senha inválidos");
        usuario = new Pessoa();
    }

    //
    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }
}
