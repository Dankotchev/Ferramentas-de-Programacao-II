package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.PessoaController;
import br.edu.ifsp.pep.model.Pessoa;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class Autorizacao implements PhaseListener {

    @Inject
    private PessoaController pessoaController;

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println(" Após (after): " + event.getPhaseId());

        FacesContext facesContext = event.getFacesContext();
        String pagina = facesContext.getViewRoot().getViewId();
        Pessoa pessoaAutenticada = pessoaController.getPessoaAutenticada();

        System.out.println("Página atual: " + pagina);

        if ((pessoaAutenticada == null
                || !pessoaAutenticada.getTipo().equals("1"))
                && pagina.equals("/financeiro/folhaPagamento.xhtml")) {
            System.out.println("Redirecionando...");
            try {
                facesContext.getExternalContext()
                        .redirect("/03PhaseListener/index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
