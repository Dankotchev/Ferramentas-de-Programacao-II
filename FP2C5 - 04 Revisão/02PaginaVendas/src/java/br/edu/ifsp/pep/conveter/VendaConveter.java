package br.edu.ifsp.pep.conveter;

import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.model.Venda;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Venda.class)
public class VendaConveter implements Converter<Venda> {

    @Override
    public Venda getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;

        VendaDAO vendaDAO = CDI.current()
                .select(VendaDAO.class)
                .get();
        
        return vendaDAO.findById(Integer.parseInt(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Venda venda) {
        if (venda == null)
            return null;

        return venda.getId().toString();
    }
}
