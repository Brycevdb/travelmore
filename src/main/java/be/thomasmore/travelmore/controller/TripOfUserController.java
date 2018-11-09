package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.AccomodationService;
import be.thomasmore.travelmore.service.TripOfUserService;
import be.thomasmore.travelmore.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class TripOfUserController implements Serializable{

    private TripOfUserService tripOfUserService;

    public List<TripOfUser> getTripByUserId (int userId) {
        return this.tripOfUserService.findByUserId(userId);
    }

    public String index(){

        return "mijnReizen";
    }
}
