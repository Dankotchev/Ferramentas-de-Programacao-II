package br.edu.ifsp.pep.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @Column(name = "login", length = 15, nullable = false)
    @Size(min = 3, max = 15)
    private String login;

    @Column(name = "senha", length = 15, nullable = false)
    @Size(min = 3, max = 15)
    private String senha;

    @Column(name = "nome", length = 40, nullable = false)
    @Size(min = 3, max = 40)
    private String nome;

    @Column(name = "tipo", length = 3, nullable = false)
    @Size(min = 1, max = 3)
    private String tipo;

    //
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.login, other.login);
    }

}
