package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CidadeDAO;
import br.edu.ifsp.pep.dao.EstadoDAO;
import br.edu.ifsp.pep.model.Cidade;
import br.edu.ifsp.pep.model.Estado;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
//@SessionScoped // Não apresenta mais as cidades
@RequestScoped // Com request da erro mais apresenta as cidades
public class ConsultaController implements Serializable {

    @Inject
    private CidadeDAO cidadeDAO;
    private List<Cidade> listaCidades;
    private Cidade cidadeSelecionada;
    
    @Inject
    private EstadoDAO estadoDAO;
    private List<Estado> listaEstados;
    private Estado estadoSelecionado;
    

    public void exibirCidade(){
        String mensagem = "Cidade Selecionada:\n";
        if (cidadeSelecionada != null) {
            mensagem += cidadeSelecionada.getNome();
            Mensagem.info(mensagem);
            System.out.println(mensagem);
        }
        else {
            mensagem = mensagem + "Nenhuma cidade selecionada.";
        }
    }
    
    //
    public List<Cidade> getListaCidades() {
        if (this.listaCidades == null) {
            listaCidades = cidadeDAO.buscarTodasPorEstado(estadoSelecionado);
        }
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<Estado> getListaEstados() {
        if (this.listaEstados == null) {
            this.listaEstados = estadoDAO.buscarTodos();
        }
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

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
