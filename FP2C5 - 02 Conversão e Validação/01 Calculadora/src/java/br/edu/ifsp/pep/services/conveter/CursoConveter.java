package br.edu.ifsp.pep.services.conveter;

import br.edu.ifsp.pep.model.Curso;
import br.edu.ifsp.pep.services.dao.CursoDAO;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;

@Named
@FacesConverter("cursoConveter")
public class CursoConveter implements Converter<Curso> {

    @EJB
    private CursoDAO cursoDAO;

    @Override
    public Curso getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString.equals("") || valorString == null)
            return null;
        
        return this.cursoDAO.buscarPorId(Integer.valueOf(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Curso curso) {
        if (curso == null)
            return null;
        
        return curso.getId().toString();
    }

}
