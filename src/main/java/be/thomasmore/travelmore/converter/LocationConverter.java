package be.thomasmore.travelmore.converter;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "locationConverter")
@Model
public class LocationConverter implements Converter {

    @EJB
    private LocationService _locationservice;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Location l = this._locationservice.findLocationById(Integer.parseInt(value));
            return l;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (!(value instanceof Location)) {
            return null;
        }

        String s = String.valueOf(((Location) value).getId());

        return s;
    }
}