package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;


import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class LocationController {
    private Location newLocation = new Location();
    private List<Location> locations = new ArrayList<Location>();
    private Location selected;

    private String search;

    @Inject
    private LocationService locationService;

    public Location getNewLocation() {
        return newLocation;
    }

    public void reset(){
        this.locations = this.locationService.findAllLocations();
    }

    public void resetFields(){
        this.search = "";
    }

    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    public Location getSelected() {
        if(this.selected == null){
            selected = new Location();
        }

        return selected;
    }

    public void setSelected(Location selected) {
        this.selected = selected;
    }

    public List<Location> getLocations(){
        if(this.search != null && this.search.length() >= 3) {
            this.locations = this.locationService.getAllByName(this.search);
        }else{
            reset();
        }

        return this.locations;
    }

    public String showAccomodations(Location location) {
        selected = location;
        return "location";
    }

    public void submit(){
        this.locationService.insert(newLocation);
    }

    public String index(Location location){
        this.newLocation = location;

        return "index_location";
    }

    public String goTo(Location location) {
        return "index";
    }

    public List<Location> complete(String search) {
        this.search = search;

        System.out.println("SEARCH: " + this.search);

        return this.locationService.getAllByName(this.search);
    }
}
