package br.edu.ifsp.pep.service.dao;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public Pessoa buscarPorLoginSenha(String login, String senha) {
        TypedQuery<Pessoa> query = em.createQuery(
                "Select p FROM Pessoa p WHERE p.login = :login AND p.senha = :senha",
                Pessoa.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void inserir(Pessoa pessoa) {
        this.em.persist(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        this.em.merge(pessoa);
    }

    public void remover(Pessoa pessoa) {
        this.em.remove(this.em.merge(pessoa));
    }

    public List<Pessoa> buscarTodos() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();
    }
}
