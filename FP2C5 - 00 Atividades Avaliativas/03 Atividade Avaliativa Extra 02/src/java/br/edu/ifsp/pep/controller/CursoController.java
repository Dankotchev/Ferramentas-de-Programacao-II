package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Curso;
import br.edu.ifsp.pep.services.CursoDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import util.Mensagem;

@Named
@ApplicationScoped
public class CursoController implements Serializable {

    @EJB
    private final CursoDAO cursoDAO = new CursoDAO();
    private Curso cursoInserir = new Curso();
    private Date dataAtual = new Date();

    public void cadastrarCurso() {
        if (cursoInserir.getDataInicio().before(cursoInserir.getDataFim())) {
            this.cursoDAO.inserir(this.cursoInserir);
            this.cursoInserir = new Curso();
            Mensagem.info("Curso cadastrado com sucesso");
        } else
            Mensagem.error("Data de término anterior a data de início");
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
}
