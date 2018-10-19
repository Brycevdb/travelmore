package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Accomodation;
import be.thomasmore.travelmore.service.AccomodationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class AccomodationController {
    private Accomodation newAccomodation = new Accomodation();

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

    public List<Accomodation> getAccomodationByLocation(int plaatsId) {
        return this.accomodationService.findAccomodationByLocation(plaatsId);
    }

    public List<Accomodation> getAccomodationByFreePlaces (int freePlaces) {
        return this.accomodationService.findAccomodationByFreePlaces(freePlaces);
    }

    public String index(Accomodation accomodation) {
        this.newAccomodation = accomodation;

        return "index_accomodation";
    }
}
