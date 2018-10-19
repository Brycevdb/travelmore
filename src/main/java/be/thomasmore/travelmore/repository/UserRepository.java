package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        List<User> users = entityManager.createNamedQuery(User.FIND_ALL, User.class).getResultList();

        if(users == null){
            return new ArrayList<>();
        }

        return users;
    }

    public User findByMailAndPassword(String mail, String pass){
        return entityManager.createNamedQuery(User.FIND_BY_MAIL_AND_PASS, User.class).setParameter("mail", mail).setParameter("pass", pass).getSingleResult();
    }

    public void insert(User user) {
        entityManager.persist(user);
    }
}