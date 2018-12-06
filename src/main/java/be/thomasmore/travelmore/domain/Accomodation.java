package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accomodation")
@NamedQueries(
        {
                @NamedQuery(
                        name = Accomodation.FIND_ALL,
                        query = "SELECT a FROM Accomodation a"
                ),
                @NamedQuery(
                        name = Accomodation.FIND_BYLOCATION,
                        query = "SELECT a FROM Accomodation a WHERE a.location = :location"
                ),
                @NamedQuery(
                        name = Accomodation.FIND_BYFREEPLACES,
                        query = "SELECT a FROM Accomodation a WHERE a.freePlaces >= :freePlaces"
                )
        }
)
public class Accomodation {
    public static final String FIND_ALL = "accomodation.findAll";
    public static final String FIND_BYLOCATION = "accomodation.findByLocation";
    public static final String FIND_BYFREEPLACES = "accomodation.findByFreePlaces";

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "freePlaces")
    private int freePlaces;
    @Column(name = "priceAPerson")
    private double priceAPerson;
    @Column(name = "photourl")
    private String photourl;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "accomodation")
    private List<Trip> trips;

    @ManyToOne
    @JoinColumn(name = "periodId")
    private Period period;

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

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public double getPriceAPerson() {
        return priceAPerson;
    }

    public void setPriceAPerson(double pricaAPerson) {
        this.priceAPerson = pricaAPerson;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}
