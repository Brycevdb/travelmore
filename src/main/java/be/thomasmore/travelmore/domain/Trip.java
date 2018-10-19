package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "trip")

public class Trip {
    public static final String FIND_ALL = "trip.findAll";

    @Id
    private int id;
    @Column (name = "departure")
    private int departure;
    @Column (name = "accomodationId")
    private int accomodationId;
    @Column (name = "transportId")
    private int transportId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(int accomodationId) {
        this.accomodationId = accomodationId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }
}
