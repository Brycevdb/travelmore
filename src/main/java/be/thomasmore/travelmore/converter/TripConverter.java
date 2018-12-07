package be.thomasmore.travelmore.converter;

import be.thomasmore.travelmore.domain.Trip;
import be.thomasmore.travelmore.service.TripService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(value = "tripConverter")
public class TripConverter implements Converter {

    @EJB
    private TripService _tripService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valueToRender) {
        // Convert MyObj to its unique String representation.
        if (!(valueToRender instanceof Trip)) {
            return null;
        }

        String s = String.valueOf(((Trip) valueToRender).getId());

        return s;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        // Convert String to MyObj.
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            Trip t = this._tripService.findTripById(Integer.parseInt(submittedValue));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
