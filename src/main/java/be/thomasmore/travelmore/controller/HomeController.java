package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.repository.LocationRepository;
import be.thomasmore.travelmore.service.MailService;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import javax.mail.MessagingException;

@Named(value = "homeController")
@ViewScoped
public class HomeController {

    @Inject
    private LocationRepository locationRepository;

    private List<Location> locations;
    private String statusMessage = "";

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
    public String send(String email, String subject, String message) {
        statusMessage = "Message Sent";
        try {
            MailService.sendMessage(email, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
        return "index";
    }
}