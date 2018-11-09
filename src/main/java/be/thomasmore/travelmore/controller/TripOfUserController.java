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

    public List<TripOfUser> getTripsByUserId (int userId) {
        if(userId != 0){
            return this.tripOfUserService.findByUserId(userId);
        }
        return null;
    }

    public String index(){

        return "mijnReizen";
    }


}
