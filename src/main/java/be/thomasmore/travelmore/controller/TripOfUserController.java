package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.AccomodationService;
import be.thomasmore.travelmore.service.TripOfUserService;
import be.thomasmore.travelmore.service.UserService;
import be.thomasmore.travelmore.domain.TripOfUser;

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

    public List<TripOfUser> getTripByUserId (int userId) {
        return this.tripOfUserService.findByUserId(userId);
    }

    public String index(){

        //addReisTest();
        return "mijnReizen";
    }

    public void addReisTest(){

        TripOfUser tos = new TripOfUser();
        tos.setId(1);tos.setPaymentId(1);tos.setTotalpeeps(1);tos.setTotalprice(15);tos.setTripId(1);tos.setUserId(1);

        this.tripOfUserService.insert(tos);
    }
}
