package br.edu.ifsp.pep.listener;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.servlet.http.HttpServletRequest;

public class Autorizacao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println(" Após (after): " + event.getPhaseId());
        
        HttpServletRequest request = (HttpServletRequest) event.getFacesContext()
                .getExternalContext()
                .getRequest();
        
        System.out.println("Path: " + request.getServletPath());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println(" Antes (before): " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
