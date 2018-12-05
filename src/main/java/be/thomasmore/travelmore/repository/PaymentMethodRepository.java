package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.PaymentMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public PaymentMethod findById(int id) {
        return entityManager.find(PaymentMethod.class, id);
    }
    public List<PaymentMethod> findAll(){
        List<PaymentMethod> paymentMethods = entityManager.createNamedQuery(PaymentMethod.FIND_ALL, PaymentMethod.class).getResultList();

        if(paymentMethods == null){
            return new ArrayList<>();
        }
        return paymentMethods;
    }

    public PaymentMethod findByName(String name) {
        return entityManager.createNamedQuery(PaymentMethod.FIND_BYNAME, PaymentMethod.class).setParameter("name", name).getSingleResult();
    }
}
