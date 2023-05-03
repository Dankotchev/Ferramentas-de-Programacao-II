package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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

}
