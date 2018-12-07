package be.thomasmore.travelmore.converter;

import be.thomasmore.travelmore.domain.Accomodation;
import be.thomasmore.travelmore.service.AccomodationService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "accomodationConverter")
@Model
public class AccomodationConverter implements Converter {

    @EJB
    private AccomodationService _accomodationService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valueToRender) {
        // Convert MyObj to its unique String representation.
        if (!(valueToRender instanceof Accomodation)) {
            return null;
        }

        String s = String.valueOf(((Accomodation) valueToRender).getId());

        return s;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        // Convert String to MyObj.
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            Accomodation a = this._accomodationService.findById(Integer.parseInt(submittedValue));
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
