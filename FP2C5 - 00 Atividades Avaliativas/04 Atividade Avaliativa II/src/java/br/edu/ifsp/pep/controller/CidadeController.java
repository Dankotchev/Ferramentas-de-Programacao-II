package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CidadeDAO;
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
public class CidadeController implements Serializable {

    @Inject
    private CidadeDAO cidadeDAO;
    private List<Cidade> listaCidades;
    private Cidade cidadeSelecionada;
    
    private Estado estadoSelecionado;
    

    public void exibirCidade(){
        String mensagem = "Cidade Selecionada:\n";
        if (cidadeSelecionada != null) {
            mensagem += cidadeSelecionada.getNome();
        }
        else {
            mensagem = mensagem + "Nenhuma cidade selecionada.";
        }
            Mensagem.info(mensagem);
            System.out.println(mensagem);
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
