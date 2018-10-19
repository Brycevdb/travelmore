package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Accomodation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class AccomodationRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Accomodation findById(int id) {
        return entityManager.find(Accomodation.class, id);
    }

    public List<Accomodation> findAll() {
        List<Accomodation> accomodations = entityManager.createNamedQuery(Accomodation.FIND_ALL, Accomodation.class).getResultList();

        if (accomodations == null) {
            return new ArrayList<>();
        }

        return accomodations;
    }

    public List<Accomodation> findByLocation(int plaatsId) {
        List<Accomodation> accomodations = entityManager.createNamedQuery(Accomodation.FIND_BYLOCATION, Accomodation.class).setParameter("plaatsId", plaatsId).getResultList();

        if (accomodations == null) {
            return new ArrayList<>();
        }

        return accomodations;
    }

    public List<Accomodation> findByFreePlaces(int freePlaces) {
        List<Accomodation> accomodations = entityManager.createNamedQuery(Accomodation.FIND_BYFREEPLACES, Accomodation.class).setParameter("freePlaces", freePlaces).getResultList();

        if (accomodations == null) {
            return new ArrayList<>();
        }

        return accomodations;
    }
}
