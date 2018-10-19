package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "paymentMethod")

public class PaymentMethod {
    public static final String FIND_ALL = "paymentMethod.findAll";
    @Id
    private int id;
    @Column(name = "userId")
    private int userId;
    @Column (name = "paymentmethodId")
    private int paymentmethodId;
    @Column (name = "extra")
    private String extra;
    @Column (name = "active")
    private boolean active;

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

    public int getPaymentmethodId() {
        return paymentmethodId;
    }

    public void setPaymentmethodId(int paymentmethodId) {
        this.paymentmethodId = paymentmethodId;
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
