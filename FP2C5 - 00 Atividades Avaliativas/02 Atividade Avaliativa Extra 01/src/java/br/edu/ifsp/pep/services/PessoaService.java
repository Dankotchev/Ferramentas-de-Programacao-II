package br.edu.ifsp.pep.services;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
public class PessoaService implements Serializable {

    private List<Pessoa> pessoas;

    public Pessoa login(String login, String senha) {
        // Um objeto com menor valor de id possivel, para caso não encontre
        //  ter a possibilidade de retornar um erro
        Pessoa p = new Pessoa(Integer.MIN_VALUE);
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getLogin().equals(login)
                    && pessoa.getSenha().equals(senha)) {
                p = pessoa;
            }
        }
        return p;
    }

    public void carregarPessoa() {
        pessoas = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            pessoas.add(new Pessoa(i, "Pessoa " + i, "login" + i, "senha" + i));
        }
    }

}
