package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Period;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Period findById(int id) {
        return entityManager.find(Period.class, id);
    }

    public List<Period> findAll() {
        List<Period> periods = entityManager.createNamedQuery(Period.FIND_ALL, Period.class).getResultList();
        if (periods == null) {
            return new ArrayList<>();
        }

        return periods;
    }

    public void insert(Period period) {
        entityManager.persist(period);
    }
}
