package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.repository.LocationRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    public HomeController() {
    }

    public String index() {
        return "index";
    }
}