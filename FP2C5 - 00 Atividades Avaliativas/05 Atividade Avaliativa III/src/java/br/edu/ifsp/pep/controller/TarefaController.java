package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.TarefaDAO;
import br.edu.ifsp.pep.model.Tarefa;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import util.Mensagem;

@Named
@SessionScoped
public class TarefaController implements Serializable {

    @EJB
    private TarefaDAO tarefaDAO = new TarefaDAO();
    private Tarefa tarefaSelecionada;
    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> listaTarefas;

    public void cadastrarTarefa() {
        this.tarefa.setDataCadastro(dataAtual());
        this.tarefa.setDataModificacao(dataAtual());
        this.tarefa.setStatus("CADASTRADA");
        this.tarefaDAO.inserir(tarefa);
        this.tarefa = new Tarefa();
        this.listaTarefas = null;
        Mensagem.info("Tarefa Cadastrada");
    }

    public void removerTarefa() {
        if (this.tarefaSelecionada.getStatus().equalsIgnoreCase("CANCELADA")) {
            this.tarefaDAO.excluir(tarefaSelecionada);
            this.tarefaSelecionada = null;
            this.listaTarefas = null;
            Mensagem.info("Tarefa excluída");
        } else
            Mensagem.warn("Não foi possivel excluir. Selecione apenas tarefas canceladas.");
    }

    public void cancelarTarefa() {
        if (this.tarefaSelecionada.getStatus().equalsIgnoreCase("CADASTRADA")) {
            this.tarefaSelecionada.setStatus("CANCELADA");
            this.tarefaSelecionada.setDataModificacao(new Date());
            this.tarefaDAO.alterar(tarefaSelecionada);
            this.tarefaSelecionada = null;
            this.listaTarefas = null;
            Mensagem.info("Tarefa cancelada");
        } else
            Mensagem.warn("Não foi possivel cancelar. Selecione apenas tarefas cadastradas.");
    }

    public void finalizarTarefa() {
        if (this.tarefaSelecionada.getStatus().equalsIgnoreCase("CADASTRADA")) {
            this.tarefaSelecionada.setStatus("FINALIZADA");
            this.tarefaSelecionada.setDataModificacao(new Date());
            this.tarefaDAO.alterar(tarefaSelecionada);
            this.tarefaSelecionada = null;
            this.listaTarefas = null;
            Mensagem.info("Tarefa finalizar");
        } else
            Mensagem.warn("Não foi possivel finalizar. Selecione apenas tarefas cadastradas.");
    }

    public Date dataAtual() {
        return new Date();
    }

    //
    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getListaTarefas() {
        if (this.listaTarefas == null)
            this.listaTarefas = this.tarefaDAO.findAll();
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }
}
