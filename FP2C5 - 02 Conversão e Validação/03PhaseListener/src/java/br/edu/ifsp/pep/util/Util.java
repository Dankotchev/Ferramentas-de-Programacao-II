package br.edu.ifsp.pep.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class Util {
    
    public static void addMessageInformation(String message) {
        FacesContext.getCurrentInstance()
                .addMessage(null, 
        new FacesMessage(
                FacesMessage.SEVERITY_INFO, 
                "", message));
    }

    public static void addMessageWarning(String message) {
        FacesContext.getCurrentInstance()
    .addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "Atenção", message));
    }

    public static void addMessageError(String message) {
        FacesContext.getCurrentInstance()
        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Erro", message));
    }
    
}
