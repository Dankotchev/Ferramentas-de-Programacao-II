package br.edu.ifsp.pep.tables.controller;

import br.edu.ifsp.pep.tables.model.Categoria;
import br.edu.ifsp.pep.tables.services.dao.CategoriaDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoriaController implements Serializable{
    
    @EJB
    private CategoriaDAO categoriaDAO;
    
    public List<Categoria> buscarTodos(){
        return this.categoriaDAO.buscarTodos();
    }

}
