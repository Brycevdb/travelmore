package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.TripOfUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class TripOfUserRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<TripOfUser> findByUserId(int userId){
        List<TripOfUser> userTrips = entityManager.createNamedQuery(TripOfUser.FIND_BYUSERID, TripOfUser.class).setParameter("userId", userId).getResultList();

        if (userTrips == null) {
            return new ArrayList<>();
        }

        return userTrips;
    }

    public void insert(TripOfUser tos) {
        entityManager.persist(tos);
    }


}
