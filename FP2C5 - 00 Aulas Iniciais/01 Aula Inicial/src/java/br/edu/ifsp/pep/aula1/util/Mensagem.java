package br.edu.ifsp.pep.aula1.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class Mensagem {

    public static void info(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Informação:",
                        mensagem)
        );
    }

    public static void warn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_WARN,
                        "Atenção:",
                        mensagem));
    }

    public static void error(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        "Erro:",
                        mensagem));
    }
}
