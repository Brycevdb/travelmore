package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.repository.TripOfUserRepository;

import javax.inject.Inject;
import java.util.List;

public class TripOfUserService {
    @Inject
    private TripOfUserRepository tripofuserRepository;


    public List<TripOfUser> findByUserId(User user) {
        return tripofuserRepository.findByUserId(user);
    }

    public void insert(TripOfUser tos) {
        this.tripofuserRepository.insert(tos);
    }


}
