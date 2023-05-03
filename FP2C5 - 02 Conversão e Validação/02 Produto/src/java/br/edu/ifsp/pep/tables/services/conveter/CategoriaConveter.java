package br.edu.ifsp.pep.tables.services.conveter;

import br.edu.ifsp.pep.tables.model.Categoria;
import br.edu.ifsp.pep.tables.services.dao.CategoriaDAO;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("categoriaConveter")
public class CategoriaConveter implements Converter<Categoria>{

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;
        
        CategoriaDAO categoriaDAO = CDI.current()
                .select(CategoriaDAO.class)
                .get();
        
        return categoriaDAO.buscarPorId(Integer.valueOf(valorString));
        }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
        if (categoria == null) return null;
        
        return categoria.getId().toString();
    }

}
