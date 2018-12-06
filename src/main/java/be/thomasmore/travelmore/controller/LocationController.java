package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.domain.Trip;
import be.thomasmore.travelmore.service.LocationService;


import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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
        this.search = search;

        return this.locationService.getAllByName(search);
    }

    public void showTrips(Location location) {
        this.search = location.getName();
        this.selected = location;

        System.out.println(this.search + this.selected.getName());
    }

    public void submit(){
        this.locationService.insert(newLocation);
    }

    public String index(Location location){
        this.newLocation = location;

        return "index_location";
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

    public void setSelect() {
        this.search = selected.getName();
    }

    public Object getAll() {
        return this.locationService.findAllLocations();
    }

    public String getSelectedName() {
        System.out.println("'" + this.getSelected().getName() + "'");
        if(this.getSelected().getName() == null){
            return " .. misschien toch eerst een bestemming kiezen?";
        }else{
            return this.selected.getName();
        }
    }
}