package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Trip;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.TripService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class TripController {
    private Trip newTrip = new Trip();
    private Trip selected;

    @Inject
    private TripService tripService;

    public Trip getNewTrip() {
        return newTrip;
    }

    public void setNewTrip(Trip newTrip) {
        this.newTrip = newTrip;
    }

    public Trip findTripById(int id) {
        return this.tripService.findTripById(id);
    }

    public List<Trip> getTrips() {
        return this.tripService.findAllTrips();
    }

    public Trip getSelected() {
        return selected;
    }

    public void setSelected(Trip selected) {
        this.selected = selected;
    }

    public void submit() {
        this.tripService.insert(newTrip);
    }

    public String goToBooking(Trip trip, User user) {
        if (user.getName() == null) {
            return "index_user";
        }
        selected = trip;
        return "booking";
    }
}