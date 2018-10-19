package be.thomasmore.travelmore.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "location")
@NamedQueries(
        {
                @NamedQuery(
                        name = Location.FIND_BY_NAME,
                        query = "SELECT l FROM Location l WHERE l.name = :name"
                ),
                @NamedQuery(
                        name = Location.FIND_ALL,
                        query = "SELECT l FROM Location l"
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
}
