package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.time.LocalDate;

@Named
@RequestScoped
public class CalculadoraDataController {

    private LocalDate dataBase;
    private Integer dias;
    private LocalDate resultado;

    public void adicionar() {
        this.resultado = LocalDate.from(dataBase).plusDays(this.dias);
    }
    
    //
    public LocalDate getDataBase() {
        return dataBase;
    }

    public void setDataBase(LocalDate dataBase) {
        this.dataBase = dataBase;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public LocalDate getResultado() {
        return resultado;
    }

    public void setResultado(LocalDate resultado) {
        this.resultado = resultado;
    }
}
