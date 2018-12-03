package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.AccomodationService;
import be.thomasmore.travelmore.service.TripOfUserService;
import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class TripOfUserController implements Serializable{

    @Inject
    private TripOfUserService tripOfUserService;

    private PaymentMethod paymentMethod;
    private int people;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public List<TripOfUser> getTripsByUserId (User user) {
        if(user != null){
            return this.tripOfUserService.findByUserId(user);
        }
        return null;
    }

    public String index(){

        return "mijnReizen";
    }

    public void booking(Trip trip, User user) {
        TripOfUser newTripOfUser = new TripOfUser();
        newTripOfUser.setTotalpeeps(people);
        newTripOfUser.setTrip(trip);
        newTripOfUser.setUser(user);
        //newTripOfUser.setPayments();
        tripOfUserService.insert(newTripOfUser);
    }
}
