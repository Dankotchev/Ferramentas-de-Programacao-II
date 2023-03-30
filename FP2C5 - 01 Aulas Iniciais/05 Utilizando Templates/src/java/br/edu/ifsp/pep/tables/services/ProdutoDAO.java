package br.edu.ifsp.pep.tables.services;

import br.edu.ifsp.pep.tables.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

// O sevidor conseguir injetar uma instnância dessa classe (Objeto sem estado)
@Stateless
public class ProdutoDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void inserir (Produto produto){
        this.em.persist(produto);
    }
    
    public void atualizar(Produto produto){
        this.em.merge(produto);
    }
    
    public void remover(Produto produto){
        this.em.remove(this.em.merge(produto));
    }
    
    public List<Produto> buscarTodos(){
       return em.createQuery("SELECT p FROM Produto p", Produto.class)
               .getResultList();
    }

}
