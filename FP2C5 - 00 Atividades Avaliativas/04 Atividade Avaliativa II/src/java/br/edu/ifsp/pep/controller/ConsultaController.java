package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CidadeDAO;
import br.edu.ifsp.pep.dao.EstadoDAO;
import br.edu.ifsp.pep.model.Cidade;
import br.edu.ifsp.pep.model.Estado;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import util.Mensagem;

@Named
@SessionScoped // Não apresenta mais as cidades
//@RequestScoped // Com request da erro mais apresenta as cidades
public class ConsultaController implements Serializable {

    @Inject
    private CidadeDAO cidadeDAO;
    private Cidade cidadeSelecionada;

    @Inject
    private EstadoDAO estadoDAO;
    private Estado estadoSelecionado;

    public void exibirCidade() {
        String mensagem = "Cidade Selecionada:\n" + cidadeSelecionada.getNome();
        Mensagem.info(mensagem);
    }

    public List<Cidade> getListaCidades() {
        return cidadeDAO.buscarTodasPorEstado(estadoSelecionado);
    }

    public List<Estado> getListaEstados() {
        return estadoDAO.buscarTodos();
    }

    //
    public Cidade getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(Cidade cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }
}
