package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "tripofuser")
@NamedQueries(
        {
                @NamedQuery(
                        name = TripOfUser.FIND_BYUSERID,
                        query = "SELECT t FROM TripOfUser t WHERE t.user >= :user"
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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payments payments;

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

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }
}
