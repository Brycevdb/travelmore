package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.*;
import be.thomasmore.travelmore.domain.TripOfUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class TripOfUserController implements Serializable{

    @Inject
    private TripOfUserService tripOfUserService;
    @Inject
    private PaymentMethodService paymentMethodService;
    @Inject
    private MailService mailService;

    private String paymentMethod;
    private List<String> paymentMethods;
    private int people;
    private String statusMessage = "";

    @PostConstruct
    public void init() {
        paymentMethods = new ArrayList<String>();
        List<PaymentMethod> all = paymentMethodService.findAllPaymentMethods();
        for (PaymentMethod paymentMethod1 : all) {
            paymentMethods.add(paymentMethod1.getName());
        }
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
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

    private void send(String email, String subject, String message) {
        statusMessage = "Message Sent";
        try {
            MailService.sendMessage(email, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
    }

    public String booking(Trip trip, User user) {
        TripOfUser newTripOfUser = new TripOfUser();
        double totalPrice = (trip.getAccomodation().getPriceAPerson() + trip.getTransport().getPriceaperson()) * people;

        newTripOfUser.setTotalpeeps(people);
        newTripOfUser.setTrip(trip);
        newTripOfUser.setUser(user);
        newTripOfUser.setTotalprice(totalPrice);
        newTripOfUser.setTransaction(new Date());
        newTripOfUser.setPaymentMethod(paymentMethodService.findByName(paymentMethod));

        tripOfUserService.insert(newTripOfUser);

        send(user.getMail(), "Boeking TravelMore", "Beste " + user.getFullname() +  ", uw reis met locatie " + trip.getLocationt().getName() + " is succesvol geboekt. Fijne reis! TravelMore Groep8 ");

        return "mijnReizen";


    }
}
