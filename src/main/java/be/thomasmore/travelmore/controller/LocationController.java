package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.domain.Trip;
import be.thomasmore.travelmore.service.LocationService;
import org.apache.http.client.utils.DateUtils;


import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean
@SessionScoped
public class LocationController {
    private Location newLocation = new Location();
    private List<Location> locations = new ArrayList<Location>();
    private Location selected;
    private List<Trip> filteredSelected;

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

    public List<Trip> getFilteredSelected() {
        return filteredSelected;
    }

    public void setFilteredSelected(List<Trip> filteredSelected) {
        this.filteredSelected = filteredSelected;
    }

    public List<Location> getLocations(){
        if(this.search != null && this.search.length() >= 3) {
            this.locations = this.locationService.getAllByName(this.search);
        }else{
            reset();
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

    public String showTrips(Location location) {
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

    public boolean filterByFreeplaces(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null||filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable)value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null||filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable)value).compareTo(Double.valueOf(filterText)) > 0;
    }

    public boolean filterByDate(Object value, Object filter, Locale locale) {

        if( filter == null ) {
            return true;
        }

        if( value == null ) {
            return false;
        }

        SimpleDateFormat filterFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat valueFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date filterDate;
        Date valueDate;

        try {
            filterDate = filterFormat.parse(filter.toString());
            valueDate = valueFormat.parse(value.toString());
        } catch (ParseException e) {return false;}

        return valueDate.after(filterDate);
    }
}
