package be.thomasmore.travelmore.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payments {
    public static final String FIND_ALL = "payments.findAll";
    @Id
    private int id;
    @Column (name = "userpaymentmethodId")
    private int userpayementmethodId;
    @Column (name = "transaction")
    private Date transaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserpayementmethodId() {
        return userpayementmethodId;
    }

    public void setUserpayementmethodId(int userpayementmethodId) {
        this.userpayementmethodId = userpayementmethodId;
    }

    public Date getTransaction() {
        return transaction;
    }

    public void setTransaction(Date transaction) {
        this.transaction = transaction;
    }
}
