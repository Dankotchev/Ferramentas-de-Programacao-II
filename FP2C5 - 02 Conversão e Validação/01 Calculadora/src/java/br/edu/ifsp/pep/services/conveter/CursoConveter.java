package br.edu.ifsp.pep.services.conveter;

import br.edu.ifsp.pep.model.Curso;
import br.edu.ifsp.pep.services.dao.CursoDAO;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("cursoConveter")
public class CursoConveter implements Converter<Curso> {

    @Override
    public Curso getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;
        
        CursoDAO cursoDAO = CDI.current()
                .select(CursoDAO.class)
                .get();
        return cursoDAO.buscarPorId(Integer.valueOf(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Curso curso) {
        if (curso == null)
            return null;        

        return curso.getId().toString();
    }

}
