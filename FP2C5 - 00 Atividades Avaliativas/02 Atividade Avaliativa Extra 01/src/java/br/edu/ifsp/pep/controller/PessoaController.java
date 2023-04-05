package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import br.edu.ifsp.pep.services.PessoaService;
import br.edu.ifsp.pep.util.Util;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class PessoaController implements Serializable {

    private Pessoa usuario = new Pessoa();
    private final PessoaService pessoaService = new PessoaService();

    public void login() {
        Pessoa login = pessoaService.login(usuario.getLogin(), usuario.getSenha());
        if (login.getId() != Integer.MIN_VALUE) {
            Util.info("Seja bem vindo " + login.getNome() + "!");
        } else {
            Util.error("Login e/ou Senha inválidos");
        }
        usuario = new Pessoa();
    }

    @PostConstruct
    private void init() {
        pessoaService.carregarPessoa();
    }

    //
    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

}
