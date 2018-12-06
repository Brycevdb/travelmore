package be.thomasmore.travelmore.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "location")
@NamedQueries(
        {
                @NamedQuery(
                        name = Location.FIND_ALL,
                        query = "SELECT l FROM Location l"
                ),
                @NamedQuery(
                        name = Location.FIND_BY_NAME,
                        query = "SELECT l FROM Location l WHERE lower(l.name) like CONCAT('%', :name, '%')"
                )
        }
)
public class Location {
    public static final String FIND_ALL = "Location.findAll";
    public static final String FIND_BY_NAME = "Location.findByName";

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "coords")
    private String coords;
    @Column(name = "photourl")
    private String photourl;

    @OneToMany(mappedBy = "location")
    private List<Accomodation> accomodations;

    @OneToMany(mappedBy = "locationt", fetch = FetchType.EAGER)
    private List<Trip> trips;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public List<Accomodation> getAccomodations() {
        return accomodations;
    }

    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}
