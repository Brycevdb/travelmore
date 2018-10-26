package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Transport;
import be.thomasmore.travelmore.service.TransportService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportController {

    private Transport newTransport = new Transport();

    @Inject
    private TransportService transportService;

    public Transport getNewTransport() {
        return newTransport;
    }

    public void setNewTransport(Transport newTransport) {
        this.newTransport = newTransport;
    }

    public Transport findTransportById(int id) {
        return this.transportService.findTransportById(id);
    }

    public List<Transport> getTransports() {
        return this.transportService.findAllTransports();
    }

    public Transport findTransportByName(String name) {
        return this.transportService.findTransportsByName(name);
    }
}
