package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;


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

    public void getByName(){
        this.locations = this.locationService.getAllByName(search);
    }
    public void reset(){
        this.locations = this.locationService.findAllLocations();
    }

    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    public Location getSelected() {
        return selected;
    }

    public void setSelected(Location selected) {
        this.selected = selected;
    }

    public List<Location> getLocations(){
        if(this.locations.size() == 0) {
            this.locations = this.locationService.findAllLocations();
        }

        return this.locations;
    }

    public List<Location> autoComplete(String search) {
        List<Location> filteredLocations = new ArrayList<Location>();
        for (Location location : this.locations) {
            if (location.getName().toLowerCase().contains(search)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String goTo(Location location) {
        return "index";
    }
}
