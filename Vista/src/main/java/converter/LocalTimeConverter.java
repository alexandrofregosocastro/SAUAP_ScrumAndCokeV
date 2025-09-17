package converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@FacesConverter("localTimeConverter")
public class LocalTimeConverter implements Converter<LocalTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        
        try {
            return LocalTime.parse(value.trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ConverterException("Error al convertir la hora. Use el formato HH:mm (ejemplo: 08:30)");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalTime value) {
        if (value == null) {
            return "";
        }
        return value.format(FORMATTER);
    }
}
