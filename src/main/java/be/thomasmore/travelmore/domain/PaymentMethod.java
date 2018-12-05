package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paymentmethod")
@NamedQueries(
        {
                @NamedQuery(
                        name = PaymentMethod.FIND_ALL,
                        query = "SELECT p FROM PaymentMethod p"
                ),
                @NamedQuery(
                        name = PaymentMethod.FIND_BYNAME,
                        query = "SELECT p FROM PaymentMethod p WHERE p.name = :name"
                )
        }
)
public class PaymentMethod {
    public static final String FIND_ALL = "paymentMethod.findAll";
    public static final String FIND_BYNAME = "paymentMethod.findByName";

    @Id
    private int id;
    @Column(name = "name")
    private String name;

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
}
