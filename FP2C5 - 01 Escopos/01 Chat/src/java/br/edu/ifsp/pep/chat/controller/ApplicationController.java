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
    private String nome;
    private String usuarioDestino;
    private String mensagem;
    
    public void enviar(){
        System.out.println("Usuário: " +nome);
        System.out.println("Usuário Destinatário: " +usuarioDestino);
        System.out.println("Mensagem: " +mensagem);
    }
    
    // Apresentar as mensgens
    // Possivelmente uma lista de usuarios, composta por uma lista de destinatarios
    // composta pelas as mensagens
        
    // Ou criar uma classe usuario, que carrega uma lista de destinatarios e suas mensagens
        
    public boolean adicionarUsuarios(String nome) {
        if (listaUsuarios.contains(nome)) {
            return false;
        }
        listaUsuarios.add(nome);
        return true;
    }

    //
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(String usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
