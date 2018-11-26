package be.thomasmore.travelmore.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payments {
    public static final String FIND_ALL = "payments.findAll";
    @Id
    private int id;
    @Column (name = "transaction")
    private Date transaction;

    @OneToOne
    @JoinColumn(name = "userpaymentId")
    private UserPaymentMethods userPaymentMethods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransaction() {
        return transaction;
    }

    public void setTransaction(Date transaction) {
        this.transaction = transaction;
    }

    public UserPaymentMethods getUserPaymentMethods() {
        return userPaymentMethods;
    }

    public void setUserPaymentMethods(UserPaymentMethods userPaymentMethods) {
        this.userPaymentMethods = userPaymentMethods;
    }
}
