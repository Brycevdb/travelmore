package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Transport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class TransportRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Transport findById(int id) {
        return entityManager.find(Transport.class, id);
    }

    public List<Transport> findAll() {
        List<Transport> transports = entityManager.createNamedQuery(Transport.FIND_ALL, Transport.class).getResultList();
        if (transports == null) {
            return new ArrayList<>();
        }
        return transports;
    }

    public Transport findByName(String name) {
        return entityManager.createNamedQuery(Transport.FIND_BY_NAME, Transport.class).setParameter("name", name).getSingleResult();
    }

    public void insert(Transport transport) {
        entityManager.persist(transport);
    }
}
