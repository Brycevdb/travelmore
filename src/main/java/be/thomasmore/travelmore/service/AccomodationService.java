package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Accomodation;
import be.thomasmore.travelmore.repository.AccomodationRepository;

import javax.inject.Inject;
import java.util.List;

public class AccomodationService {
    @Inject
    private AccomodationRepository accomodationRepository;

    public Accomodation findById(int id) {
        return accomodationRepository.findById(id);
    }

    public List<Accomodation> findAccomodationByLocation(int plaatsId) {
        return accomodationRepository.findByLocation(plaatsId);
    }

    public List<Accomodation> findAccomodationByFreePlaces(int freePlaces) {
        return accomodationRepository.findByFreePlaces(freePlaces);
    }

    public List<Accomodation> findAll() {
        return accomodationRepository.findAll();
    }
}
