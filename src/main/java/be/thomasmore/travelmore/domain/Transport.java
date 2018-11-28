package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transport")
@NamedQueries(
        {
                @NamedQuery(
                        name = Transport.FIND_ALL,
                        query = "SELECT t FROM Transport t"
                ),
                @NamedQuery(
                        name = Transport.FIND_BY_NAME,
                        query = "SELECT t FROM Transport t WHERE t.name = :name"
                )
        }
)
public class Transport {
    public static final String FIND_ALL = "transport.findAll";
    public static final String FIND_BY_NAME = "transport.findByName";

    @Id
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
