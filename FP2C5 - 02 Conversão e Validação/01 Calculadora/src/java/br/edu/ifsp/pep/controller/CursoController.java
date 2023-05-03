package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Curso;
import br.edu.ifsp.pep.services.dao.CursoDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import util.Mensagem;

@Named
@RequestScoped
public class CursoController implements Serializable {

    @EJB
    private CursoDAO cursoDAO;
    private Curso cursoInserir = new Curso();
    private Curso cursoSelecionado = new Curso();
    private Date dataAtual = new Date();

    public void cadastrarCurso() {
        if (cursoInserir.getDataInicio().before(cursoInserir.getDataFim())) {
            this.cursoDAO.inserir(this.cursoInserir);
            this.cursoInserir = new Curso();
            Mensagem.info("Curso cadastrado com sucesso");
        } else 
            Mensagem.error("Data de término anterior a data de início");
    }
    
    public List<Curso> retonarTodos (){
        return this.cursoDAO.retonarTodos();
    }
    
    public Curso buscarPorId (Integer id){
        return this.cursoDAO.buscarPorId(id);
    }
    
    public void teste(){
        System.out.println("teste");
        System.out.println(cursoSelecionado);
    }

    //
    public Curso getCursoInserir() {
        return cursoInserir;
    }

    public void setCursoInserir(Curso cursoInserir) {
        this.cursoInserir = cursoInserir;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
}
