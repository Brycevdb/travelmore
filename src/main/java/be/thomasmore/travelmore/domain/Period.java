package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "period")
@NamedQueries(
        {
                @NamedQuery(
                        name = Period.FIND_ALL,
                        query = "SELECT p FROM Period p"
                )
        }
)
public class Period {
    public static final String FIND_ALL = "period.findAll";
    @Id
    private int id;
    @Column (name = "start")
    private Date start;
    @Column (name = "end")
    private Date end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
