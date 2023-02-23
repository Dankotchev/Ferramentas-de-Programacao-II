package br.edu.ifsp.pep.appscoped.controler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import util.Mensagem;

@Named
@ApplicationScoped // Objeto mantido para toda a aplicação, ou seja, para todos os clientes da aplicação
public class PessoaControler implements Serializable {

    private final List<String> listaNomes = new ArrayList<>();
    private String nome;

    public void adicionar() {
        if (this.listaNomes.contains(nome)) {
            Mensagem.warn("Nome já cadastrado");
        } else {
            this.listaNomes.add(nome);
            Mensagem.info("Nome adicionado");
        }
    }

    // Código Gerado e necessário
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getListaNomes() {
        return listaNomes;
    }
}
