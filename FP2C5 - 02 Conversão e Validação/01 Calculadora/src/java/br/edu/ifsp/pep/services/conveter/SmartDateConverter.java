
package br.edu.ifsp.pep.services.conveter;

import jakarta.faces.FacesException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import util.Mensagem;

@FacesConverter
public class SmartDateConverter implements Converter<Object>{
    
    private static final DateFormat FORMATADOR = new SimpleDateFormat("dd/MM/yyyy");
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String valor) {
        LocalDate dataConvertida = null;
        
        // Caso não informe nenhum valor, ou esteja nulo
        if (valor ==  null || valor.equals(" "))       
            return null;
        
        if ("hoje".equalsIgnoreCase(valor))
            dataConvertida = LocalDate.now();
        
        else if ("amanha".equalsIgnoreCase(valor) 
                || "amanhã".equalsIgnoreCase(valor))
            dataConvertida = LocalDate.now().plusDays(1);
        
        else if("ontem".equalsIgnoreCase(valor))
            dataConvertida = LocalDate.now().minusDays(1);
        
        else {
            try{
                dataConvertida = FORMATADOR.parse(valor);
            }
            catch (ParseException e) {
                throw new ConverterException(Mensagem.fatal("Data Incorreta", "Informe uma Data Correta"));
            }
        }
            
        
        
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
}

}
