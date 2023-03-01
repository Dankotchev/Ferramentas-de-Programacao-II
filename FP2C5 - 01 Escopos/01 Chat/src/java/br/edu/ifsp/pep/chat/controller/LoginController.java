package br.edu.ifsp.pep.chat.controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import util.Mensagem;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private ApplicationController applicationController;
    private String nome;

    public String autenticar() {
        System.out.println("Usuário: " + nome);
        if (!applicationController.adicionarUsuarios(nome)) {
            Mensagem.error("Usuário já cadastrado");
            return null; // Premanece na mesma página
        }
        return "chat";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
