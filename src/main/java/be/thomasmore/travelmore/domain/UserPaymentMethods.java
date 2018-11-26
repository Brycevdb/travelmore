package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "userpaymentmethod")
@NamedQueries({
        @NamedQuery(
                name = UserPaymentMethods.FIND_ALL,
                query = "SELECT u FROM UserPaymentMethods u"
        )
})
public class UserPaymentMethods {
    public static final String FIND_ALL = "userPaymentMethod.findAll";

    @Id
    private int id;
    @Column(name = "extra")
    private String extra;
    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "paymentmethodId")
    private PaymentMethod paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
