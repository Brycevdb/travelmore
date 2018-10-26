package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.TripOfUser;
import be.thomasmore.travelmore.repository.TripOfUserRepository;

import javax.inject.Inject;
import java.util.List;

public class TripOfUserService {
    @Inject
    private TripOfUserRepository tripofuserRepository;

    public TripOfUser findById(int userId) {

        return tripofuserRepository.findById(userId);
    }


}
