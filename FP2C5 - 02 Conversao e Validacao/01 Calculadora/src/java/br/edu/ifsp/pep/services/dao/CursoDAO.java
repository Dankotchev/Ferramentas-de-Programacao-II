package br.edu.ifsp.pep.services.dao;

import br.edu.ifsp.pep.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CursoDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void inserir(Curso curso) {
        this.em.persist(curso);
    }

    public List<Curso> retonarTodos() {
        return em.createNamedQuery("retonarTodos", Curso.class)
                .getResultList();
    }

    public Curso buscarPorId(Integer id) {
        return em.find(Curso.class, id);
    }
}
