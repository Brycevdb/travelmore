package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private User currentUser;

    public String index(){
        if(this.currentUser == null) {
            return "index_user";
        }

        return "user_profile";
    }
}
