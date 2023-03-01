package br.edu.ifsp.pep.chat.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ApplicationController {

    private List<String> listaUsuarios = new ArrayList<>();
    private String listagem;

    public boolean adicionarUsuarios(String nome) {
        if (listaUsuarios.contains(nome)) {
            return false;
        }
        listaUsuarios.add(nome);
        return true;
    }

    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getListagem() {
        return listagem;
    }

    public void setListagem(String listagem) {
        this.listagem = listagem;
    }

}
