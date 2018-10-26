package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Trip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Trip findById(int id) {
        return entityManager.find(Trip.class, id);
    }

    public List<Trip> findAll() {
        List<Trip> trips = entityManager.createNamedQuery(Trip.FIND_ALL, Trip.class).getResultList();

        if (trips == null) {
            return new ArrayList<>();
        }

        return trips;
    }

    public void insert(Trip trip) {
        entityManager.persist(trip);
    }
}
