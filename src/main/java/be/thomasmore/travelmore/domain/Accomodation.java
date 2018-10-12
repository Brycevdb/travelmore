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
                        name = Accomodation.FIND_BYPLAATS,
                        query = "SELECT a FROM Accomodation a WHERE a.plaatsId = :plaatsId"
                ),
                @NamedQuery(
                        name = Accomodation.FIND_BYFREEPLACES,
                        query = "SELECT a FROM Accomodation a WHERE a.freePlaces > :freePlaces"
                )
        }
)
public class Accomodation {
    public static final String FIND_ALL = "location.findAll";
    public static final String FIND_BYPLAATS = "location.findByPlaats";
    public static final String FIND_BYFREEPLACES = "location.findByFreePlaces";

    @Id
    private int id;
    @Column(name = "plaatsId")
    private int plaatsId;
    @Column(name = "periodId")
    private int periodId;
    @Column(name = "freePlaces")
    private int freePlaces;
    @Column(name = "priceAPerson")
    private double priceAPerson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaatsId() {
        return plaatsId;
    }

    public void setPlaatsId(int plaatsId) {
        this.plaatsId = plaatsId;
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
