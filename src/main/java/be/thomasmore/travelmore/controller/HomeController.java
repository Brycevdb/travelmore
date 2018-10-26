package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.repository.LocationRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "homeController")
@ViewScoped
public class HomeController {

    @Inject
    private LocationRepository locationRepository;

    private List<Location> locations;

    public HomeController() { }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void find(String search){
        this.locations = this.locationRepository.getAllByName(search);
    }

    public String index() {
        return "index";
    }
}