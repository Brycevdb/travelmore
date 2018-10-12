package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accomodation")
public class Accomodation {

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
