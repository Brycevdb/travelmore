package be.thomasmore.travelmore.converter;

import be.thomasmore.travelmore.domain.Transport;
import be.thomasmore.travelmore.service.TransportService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "transportConverter")
@Model
public class TransportConverter implements Converter {

    @EJB
    private TransportService _transportService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valueToRender) {
        // Convert MyObj to its unique String representation.
        if (!(valueToRender instanceof Transport)) {
            return null;
        }

        String s = String.valueOf(((Transport) valueToRender).getId());

        return s;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        // Convert String to MyObj.
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            Transport t = this._transportService.findTransportById(Integer.parseInt(submittedValue));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
