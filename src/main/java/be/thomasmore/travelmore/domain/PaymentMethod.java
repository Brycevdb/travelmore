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
                )
        }
)
public class PaymentMethod {
    public static final String FIND_ALL = "paymentMethod.findAll";
    @Id
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<UserPaymentMethods> userPaymentMethods;

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

    public List<UserPaymentMethods> getUserPaymentMethods() {
        return userPaymentMethods;
    }

    public void setUserPaymentMethods(List<UserPaymentMethods> userPaymentMethods) {
        this.userPaymentMethods = userPaymentMethods;
    }
}
