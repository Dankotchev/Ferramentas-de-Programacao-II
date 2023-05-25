package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.EstadoDAO;
import br.edu.ifsp.pep.model.Estado;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped // Não apresenta mais as cidades
//@RequestScoped // Com request da erro mais apresenta as cidades
public class EstadoController implements Serializable {
    
    @Inject
    private EstadoDAO estadoDAO;
    private List<Estado> listaEstados;

    public List<Estado> getListaEstados() {
        if (this.listaEstados == null) {
            this.listaEstados = estadoDAO.buscarTodos();
        }
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
