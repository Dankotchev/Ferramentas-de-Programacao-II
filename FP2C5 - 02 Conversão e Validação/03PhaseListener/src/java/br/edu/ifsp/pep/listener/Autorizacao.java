package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.PessoaController;
import br.edu.ifsp.pep.model.Pessoa;
import jakarta.faces.application.NavigationHandler;
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

        if (event.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES)
            System.out.println("Após a fase de Apply Request Values");

        FacesContext context = event.getFacesContext();
        String pagina = context.getViewRoot().getViewId();
        Pessoa pessoaAutenticada = pessoaController.getPessoaAutenticada();

        System.out.println("Página atual: " + pagina);

        // Bloqueando páginas da seção Financeira do projeto. Limitando apenas ao
        //  tipo permitido
        if ((pessoaAutenticada == null
                || !pessoaAutenticada.getTipo().equals("1"))
                && pagina.startsWith("/financeiro/")) {
            System.out.println("Redirecionando...");

            // Redirecionando usando métodos do facesContexts
//            try {
//                context.getExternalContext()
//                        .redirect("/03PhaseListener/index.xhtml");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            // Outra forma de redirecionar páginas, usando NavigationHandler
            NavigationHandler navigationHandler = context.getApplication()
                    .getNavigationHandler();

            navigationHandler.handleNavigation(context, null, "erro");
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
