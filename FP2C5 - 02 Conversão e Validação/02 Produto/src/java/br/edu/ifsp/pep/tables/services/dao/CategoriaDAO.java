package br.edu.ifsp.pep.tables.services.dao;

import br.edu.ifsp.pep.tables.model.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoriaDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void inserir(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria) {
        this.em.remove(this.em.merge(categoria));
    }

    public List<Categoria> buscarTodos() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class)
                .getResultList();
    }

    public Categoria buscarPorId(Integer id) {
        return em.find(Categoria.class, id);
    }
}
