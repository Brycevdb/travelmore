package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class TripOfUserController implements Serializable{

    public String index(){

        return "mijnReizen";
    }
}
