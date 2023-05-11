package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Cidade;
import br.edu.ifsp.pep.model.Estado;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CidadeDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public List<Cidade> buscarTodasPorEstado(Estado estado) {
        return em.createNamedQuery("buscarTodasPorEstado")
                .setParameter("estado", estado)
                .getResultList();
    }
    
    public Cidade buscarPorId(Integer id){
        return em.find(Cidade.class, id);
    }
}
