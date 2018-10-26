package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Transport;
import be.thomasmore.travelmore.repository.TransportRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TransportService {
    @Inject
    private TransportRepository transportRepository;

    public Transport findTransportById(int id) {
        return  transportRepository.findById(id);
    }

    public List<Transport> findAllTransports () {
        return transportRepository.findAll();
    }

    public Transport findTransportsByName(String name) {
        return transportRepository.findByName(name);
    }

    public void insert(Transport transport) {
        transportRepository.insert(transport);
    }
}
