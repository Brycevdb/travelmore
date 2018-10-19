package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class LocationRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Location findById(int id) {
        return entityManager.find(Location.class, id);
    }

    public List<Location> findAll() {
        List<Location> locations = entityManager.createNamedQuery(Location.FIND_ALL, Location.class).getResultList();

        if(locations == null){
            return new ArrayList<>();
        }

        return locations;
    }

    public List<Location> getAllByName(String name){
        return entityManager.createNamedQuery(Location.FIND_BY_NAME, Location.class).setParameter("name", name).getResultList();
    }

    public void insert(Location location) {
        entityManager.persist(location);
    }
}
