package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Accomodation;
import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.repository.AccomodationRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AccomodationService {
    @Inject
    private AccomodationRepository accomodationRepository;

    public Accomodation findById(int id) {
        return accomodationRepository.findById(id);
    }

    public List<Accomodation> findAccomodationByLocation(Location location) {
        return accomodationRepository.findByLocation(location);
    }

    public List<Accomodation> findAccomodationByFreePlaces(int freePlaces) {
        return accomodationRepository.findByFreePlaces(freePlaces);
    }

    public List<Accomodation> findAllAccomodations() {
        return accomodationRepository.findAll();
    }
}
