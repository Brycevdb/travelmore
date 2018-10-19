package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Payments;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class PaymentsRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Payments findById(int id) {
        return entityManager.find(Payments.class, id);
    }
    public List<Payments> findAll(){
        List<Payments> payments = entityManager.createNamedQuery(Payments.FIND_ALL, Payments.class).getResultList();

        if(payments == null){
            return new ArrayList<>();
        }
        return payments;
    }
}
