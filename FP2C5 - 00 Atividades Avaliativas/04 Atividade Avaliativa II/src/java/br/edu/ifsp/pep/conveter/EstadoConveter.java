package br.edu.ifsp.pep.conveter;

import br.edu.ifsp.pep.dao.EstadoDAO;
import br.edu.ifsp.pep.model.Estado;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Estado.class)
public class EstadoConveter implements Converter<Estado> {

    @Override
    public Estado getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;

        EstadoDAO EstadoDAO = CDI.current()
                .select(EstadoDAO.class)
                .get();
        return EstadoDAO.buscarPorId(Integer.valueOf(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Estado estado) {
        if (estado == null)
            return null;

        return estado.getId().toString();
    }

}
