package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.repository.LocationRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocationService {
    @Inject
    private LocationRepository locationRepository;

    public Location findLocationById(int id) {
        return locationRepository.findById(id);
    }

    public List<Location> getAllByName(String search) {
        return locationRepository.getAllByName(search);
    }

    public void removeById(int id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    public void updateName(int id, String newName) {
        Location location = locationRepository.findById(id);
        location.setName(newName);
    }

    public void insert(Location location) {
        locationRepository.insert(location);
    }

    public void delete(Location location) {
        locationRepository.delete(locationRepository.findById(location.getId()));
    }
}
