package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "tripOfUser")

public class TripOfUser {
    public static final String FIND_ALL = "tripOfUser.findAll";

    @Id
    private int id;
    @Column (name = "userId")
    private int userId;
    @Column (name = "tripId")
    private int tripId;
    @Column (name = "totalprice")
    private double totalprice;
    @Column (name = "paymentId")
    private int paymentId;
    @Column (name = "totalpeeps")
    private int totalpeeps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getTotalpeeps() {
        return totalpeeps;
    }

    public void setTotalpeeps(int totalpeeps) {
        this.totalpeeps = totalpeeps;
    }
}
