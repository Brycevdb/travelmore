package be.thomasmore.travelmore.domain;

import javax.persistence.*;

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
    public static final String FIND_ALL = "location.findAll";
    public static final String FIND_BYLOCATION = "location.findByLocation";
    public static final String FIND_BYFREEPLACES = "location.findByFreePlaces";

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "periodId")
    private int periodId;
    @Column(name = "freePlaces")
    private int freePlaces;
    @Column(name = "priceAPerson")
    private double priceAPerson;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
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
}
