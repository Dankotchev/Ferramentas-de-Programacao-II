package br.edu.ifsp.pep.investimento.dao;

import br.edu.ifsp.pep.investimento.model.Investimento;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InvestimentoDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void insert(Investimento investimento) {
        em.persist(investimento);
    }

    public List<Investimento> findAll() {
        return em.createQuery("SELECT i FROM Investimento i", Investimento.class)
                .getResultList();
    }
}
