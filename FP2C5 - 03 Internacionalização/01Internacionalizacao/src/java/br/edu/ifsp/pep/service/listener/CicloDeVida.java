package br.edu.ifsp.pep.service.listener;

import br.edu.ifsp.pep.controller.LocaleController;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;

public class CicloDeVida implements PhaseListener {

    @Inject
    private LocaleController localeController;

    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        UIViewRoot viewRoot = event.getFacesContext().getViewRoot();

        if (viewRoot != null
                && event.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES) {
            System.out.print("Locale: ");
            System.out.println(viewRoot.getLocale());
            viewRoot.setLocale(localeController.getLocale());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
