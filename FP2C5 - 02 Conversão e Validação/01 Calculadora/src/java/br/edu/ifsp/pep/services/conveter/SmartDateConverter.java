package br.edu.ifsp.pep.services.conveter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter("smartDate")
public class SmartDateConverter implements Converter<LocalDate> {

    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDate getAsObject(FacesContext context, UIComponent component, String dataString) {
        LocalDate dataConvertida = null;

        // Caso não informe nenhum valor, ou esteja nulo
        if (dataString == null || dataString.equals(" ")) {
            return null;
        }

        if ("hoje".equalsIgnoreCase(dataString)) {
            dataConvertida = LocalDate.now();
        } else if ("amanha".equalsIgnoreCase(dataString)
                || "amanhã".equalsIgnoreCase(dataString)) {
            dataConvertida = LocalDate.now().plusDays(1);
        } else if ("ontem".equalsIgnoreCase(dataString)) {
            dataConvertida = LocalDate.now().minusDays(1);
        } else {
            dataConvertida = LocalDate.parse(dataString, FORMATADOR);
        }
        return dataConvertida;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDate data) {
        if (data == null)
            return null;
       
        LocalDate date = (LocalDate) data;
        return date.format(FORMATADOR);
    }
}
