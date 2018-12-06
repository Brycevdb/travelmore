package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tripofuser")
@NamedQueries(
        {
                @NamedQuery(
                        name = TripOfUser.FIND_BYUSERID,
                        query = "SELECT t FROM TripOfUser t WHERE t.user = :user"
                ),
                @NamedQuery(
                        name = TripOfUser.FIND_ALL,
                        query = "SELECT t from TripOfUser t"
                )
        }
)
public class TripOfUser {
    public static final String FIND_ALL = "tripOfUser.findAll";
    public static final String FIND_BYUSERID = "tripOfUser.findByUserId";

    @Id
    private int id;
    @Column (name = "totalprice")
    private double totalprice;
    @Column (name = "totalpeeps")
    private int totalpeeps;
    @Column (name = "transaction")
    private Date transaction;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "methodId")
    private PaymentMethod paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getTotalpeeps() {
        return totalpeeps;
    }

    public void setTotalpeeps(int totalpeeps) {
        this.totalpeeps = totalpeeps;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Date getTransaction() {
        return transaction;
    }

    public void setTransaction(Date transaction) {
        this.transaction = transaction;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
