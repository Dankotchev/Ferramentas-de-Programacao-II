package br.edu.ifsp.pep.services;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateless
public class PessoaService implements Serializable {

    private List<Pessoa> pessoas;

    public Pessoa login(String login, String senha) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getLogin().equals(login)
                    && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    private void carregarPessoa() {
        this.pessoas = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            pessoas.add(new Pessoa(i, "Pessoa " + i, "login" + i, "senha" + i));
        }
    }

    public PessoaService() {
        this.carregarPessoa();
    }
}
