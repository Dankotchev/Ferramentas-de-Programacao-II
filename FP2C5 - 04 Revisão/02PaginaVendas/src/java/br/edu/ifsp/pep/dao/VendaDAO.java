package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class VendaDAO {
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public List<Venda> findAll(){
        return em.createNamedQuery("Venda.findAll", Venda.class)
                .getResultList();
    }
    
    public Venda findById (Integer Id){
        return em.createNamedQuery("Venda.findById", Venda.class)
                .setParameter("id", Id)
                .getSingleResult();
    }
}
