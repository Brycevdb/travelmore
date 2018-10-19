package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.repository.LocationRepository;
import be.thomasmore.travelmore.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class UserService {
    @Inject
    private UserRepository userRepository;

    public User findUserById(int id) {
        return this.userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public User findByMailandPassword(String mail, String pass){
        return this.userRepository.findByMailAndPassword(mail, pass);
    }

    public void updateName(int id, String newName) {
        User location = this.userRepository.findById(id);
        location.setName(newName);
    }

    public void updatePassword(int id, String password){
        User location = this.userRepository.findById(id);
        location.setPass(password);
    }

    public void insert(User user) {
        this.userRepository.insert(user);
    }
}
