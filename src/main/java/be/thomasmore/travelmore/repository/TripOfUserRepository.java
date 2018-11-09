package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.TripOfUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class TripOfUserRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public TripOfUser findById(int Id){
        return entityManager.find(TripOfUser.class, Id);
    }

    public List<TripOfUser> findByUserId(int userId) {
        List<TripOfUser> tripsOfuser = entityManager.createNamedQuery(TripOfUser.FIND_BY_USERID, TripOfUser.class).getResultList();

        if (tripsOfuser == null) {
            return new ArrayList<>();
        }
        return tripsOfuser;
    }

}
