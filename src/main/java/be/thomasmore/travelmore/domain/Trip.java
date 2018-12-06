package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trip")
@NamedQueries(
        {
                @NamedQuery(
                        name = Trip.FIND_ALL,
                        query = "SELECT t FROM Trip t"
                ),
                @NamedQuery(
                        name = Trip.FIND_BYTRANSPORT,
                        query = "SELECT t FROM Trip t WHERE t.transport = :transport"
                )
        }
)
public class Trip {
    public static final String FIND_ALL = "trip.findAll";
    public static final String FIND_BYTRANSPORT = "trip.findByTransport";

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "transportId")
    private Transport transport;

    @ManyToOne
    @JoinColumn(name = "accomodationId")
    private Accomodation accomodation;

    @ManyToOne
    @JoinColumn(name = "departure")
    private Location locationt;

    @ManyToOne
    @JoinColumn(name = "arrival")
    private Location arrival;

    @OneToMany(mappedBy = "trip", fetch = FetchType.EAGER)
    private List<TripOfUser> tripOfUsers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public Location getLocationt() {
        return locationt;
    }

    public void setLocationt(Location locationt) {
        this.locationt = locationt;
    }

    public List<TripOfUser> getTripOfUsers() {
        return tripOfUsers;
    }

    public void setTripOfUsers(List<TripOfUser> tripOfUsers) {
        this.tripOfUsers = tripOfUsers;
    }

    public Location getArrival() {
        return arrival;
    }

    public void setArrival(Location arrival) {
        this.arrival = arrival;
    }
}
