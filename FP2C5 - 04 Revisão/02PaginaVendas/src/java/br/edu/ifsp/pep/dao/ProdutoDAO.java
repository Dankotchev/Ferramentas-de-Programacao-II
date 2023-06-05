package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public List<Produto> findAll (){
        return em.createNamedQuery("Produto.findAll", Produto.class)
                .getResultList();
    }
    
    public Produto findById(Integer Id) {
        return em.createQuery("Produto.findById", Produto.class)
                .setParameter("id", Id)
                .getSingleResult();
    }
}
