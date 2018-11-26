package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocationController {
    private Location newLocation = new Location();
    private List<Location> locations = new ArrayList<Location>();

    @Inject
    private LocationService locationService;

    public Location getNewLocation() {
        return newLocation;
    }

    public void getByName(String search){
        this.locations = this.locationService.getAllByName(search);
    }

    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    public List<Location> getLocations(){
        if(this.locations.size() == 0) {
            this.locations = this.locationService.findAllLocations();
        }

        return this.locations;
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
}
