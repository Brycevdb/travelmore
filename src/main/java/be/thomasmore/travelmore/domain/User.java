package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")

public class User {
    public static final String FIND_ALL = "user.findAll";

    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "famname")
    private String famname;
    @Column (name = "role")
    private String role;
    //@Column (name = "pass")
    //iets om wachtwoord te zetten
    @Column (name = "mail")
    private String mail;
    @Column (name = "landId")
    private int landId;

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

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }
}
