package br.edu.ifsp.pep.conveter;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.model.Produto;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Produto.class)
public class ProdutoConveter implements Converter<Produto> {

    @Override
    public Produto getAsObject(FacesContext context, UIComponent component, String valorString) {
        if (valorString == null || valorString.isEmpty())
            return null;

        ProdutoDAO produtoDAO = CDI.current()
                .select(ProdutoDAO.class)
                .get();
        
        return produtoDAO.findById(Integer.parseInt(valorString));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Produto produto) {
        if (produto == null)
            return null;

        return produto.getId().toString();
    }
}
