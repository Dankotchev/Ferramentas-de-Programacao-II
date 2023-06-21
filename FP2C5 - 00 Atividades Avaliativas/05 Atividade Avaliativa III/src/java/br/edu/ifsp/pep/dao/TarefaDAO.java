
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Tarefa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TarefaDAO {
    
    @PersistenceContext(unitName = "avaliacaoPU")
    private EntityManager em;
    
    public void inserir (Tarefa tarefa){
        em.persist(tarefa);
    }
    
    public void alterar(Tarefa tarefa){
        em.merge(tarefa);
    }
    
    public void excluir(Tarefa tarefa){
        em.remove(em.merge(tarefa));
    }
    
    public List<Tarefa> findAll (){
        return em.createNamedQuery("Tarefa.findAll", Tarefa.class)
                .getResultList();
    }
}
