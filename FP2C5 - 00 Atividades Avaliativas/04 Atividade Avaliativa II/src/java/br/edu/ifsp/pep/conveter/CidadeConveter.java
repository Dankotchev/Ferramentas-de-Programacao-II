package br.edu.ifsp.pep.conveter;

import br.edu.ifsp.pep.dao.CidadeDAO;
import br.edu.ifsp.pep.model.Cidade;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("cidadeConveter")
public class CidadeConveter implements Converter<Cidade> {

    @Override
    public Cidade getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;

        CidadeDAO CidadeDAO = CDI.current()
                .select(CidadeDAO.class)
                .get();
        return CidadeDAO.buscarPorId(Integer.valueOf(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Cidade cidade) {
        if (cidade == null)
            return null;

        return cidade.getId().toString();
    }

}