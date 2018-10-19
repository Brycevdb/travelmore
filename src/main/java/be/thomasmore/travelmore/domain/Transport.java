package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "transport")

public class Transport {
    public static final String FIND_ALL = "transport.findAll";

    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "priceaperson")
    private Double priceaperson;

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

    public Double getPriceaperson() {
        return priceaperson;
    }

    public void setPriceaperson(Double priceaperson) {
        this.priceaperson = priceaperson;
    }
}
