package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleController implements Serializable{
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }
    
    public void setLocaleUS(){
        FacesContext
                .getCurrentInstance()
                .getViewRoot()
                .setLocale(Locale.US);
        this.locale = Locale.US;
    }
    
    public void setLocaleBR(){
        FacesContext
                .getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("pt", "BR"));
        this.locale = new Locale("pt", "BR");
    }
}
