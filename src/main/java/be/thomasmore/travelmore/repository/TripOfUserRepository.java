package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.domain.User;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;

public class TripOfUserRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<TripOfUser> findByUserId(User user){
        List<TripOfUser> userTrips = entityManager.createNamedQuery(TripOfUser.FIND_BYUSERID, TripOfUser.class).setParameter("user", user).getResultList();

        if (userTrips == null) {
            return new ArrayList<>();
        }

        return userTrips;
    }

    public void insert(TripOfUser tos) {
        entityManager.persist(tos);
    }


}
