package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.repository.LocationRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    private LocationRepository locationRepo;

    private List<Location> locations;

    public HomeController() {
        this.locationRepo = new LocationRepository();
    }

    public List<Location> getLocations(String name){

        if(name == null || name == ""){
            this.locations = this.locationRepo.findAll();
        }else {
            this.locations = this.locationRepo.getAllByName(name);
        }

        return this.locations;
    }

    public String index() {
        return "index";
    }


}