package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Estado;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EstadoDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public List<Estado> buscarTodos() {
        return em.createQuery("SELECT e FROM Estado e", Estado.class)
                .getResultList();
    }

    public Estado buscarPorId(Integer id) {
        return em.find(Estado.class, id);
    }
}