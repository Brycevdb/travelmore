package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Accomodation;
import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.AccomodationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class AccomodationController {
    private Accomodation newAccomodation = new Accomodation();
    private List<Accomodation> accomodations = new ArrayList<Accomodation>();

    @Inject
    private AccomodationService accomodationService;

    public Accomodation getAccomodation() {
        return newAccomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.newAccomodation = accomodation;
    }

    public List<Accomodation> getAccomodations() {
        return this.accomodationService.findAllAccomodations();
    }

    public List<Accomodation> getAccomodationByLocation(Location location) {
        return this.accomodationService.findAccomodationByLocation(location);
    }

    public List<Accomodation> getAccomodationByFreePlaces (int freePlaces) {
        return this.accomodationService.findAccomodationByFreePlaces(freePlaces);
    }

    public String index(Accomodation accomodation) {
        this.newAccomodation = accomodation;

        return "index_accomodation";
    }

    /*public String getForLocation(String id){
        this.accomodations = this.accomodationService.findAccomodationByLocation(Integer.parseInt(id));

        return "accomodations_list";
    }*/
}
