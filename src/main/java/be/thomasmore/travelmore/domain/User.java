package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = User.FIND_ALL,
                query = "SELECT l FROM User l"
        ),
        @NamedQuery(
                name = User.FIND_BY_ID,
                query = "SELECT l FROM User l WHERE l.id = :id"
        ),
        @NamedQuery(
                name = User.FIND_BY_MAIL_AND_PASS,
                query = "SELECT l FROM User l WHERE l.mail = :mail AND l.pass = :pass"
        ),
        @NamedQuery(
                name = User.FIND_BY_MAIL,
                query = "SELECT l FROM User l WHERE l.mail = :mail"
        )
})
public class User {
    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_ID = "User.findById";
    public static final String FIND_BY_MAIL_AND_PASS = "User.findByMailAndPass";
    public static final String FIND_BY_MAIL = "User.findByMail";

    @Id
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "famname")
    private String famname;
    @Column (name = "role")
    private String role;
    @Column (name = "pass")
    private String pass;
    @Column (name = "mail")
    private String mail;

    @ManyToOne
    @JoinColumn(name = "landId")
    private Location locationu;

    @OneToMany(mappedBy = "user")
    private List<UserPaymentMethods> userPaymentMethods;

    @OneToMany(mappedBy = "user")
    private List<TripOfUser>tripOfUsers;

    public User(){ }

    public User(String name, String famname, String pass, String mail){
        this.name = name;
        this.famname = famname;
        this.pass = pass;
        this.mail = mail;
        this.role = "User";
    }

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

    public String getFamname() {
        return famname;
    }

    public void setFamname(String famname) {
        this.famname = famname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() { return this.pass; }

    public void setPass(String password) { this.pass = password; }

    public String getFullname(){
        return this.name + " " + this.famname;
    }

    public List<UserPaymentMethods> getUserPaymentMethods() {
        return userPaymentMethods;
    }

    public void setUserPaymentMethods(List<UserPaymentMethods> userPaymentMethods) {
        this.userPaymentMethods = userPaymentMethods;
    }

    public Location getLocationu() {
        return locationu;
    }

    public void setLocationu(Location locationu) {
        this.locationu = locationu;
    }

    public List<TripOfUser> getTripOfUsers() {
        return tripOfUsers;
    }

    public void setTripOfUsers(List<TripOfUser> tripOfUsers) {
        this.tripOfUsers = tripOfUsers;
    }
}
