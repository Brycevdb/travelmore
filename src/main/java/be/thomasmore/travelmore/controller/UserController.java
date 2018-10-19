package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "userController")
@ViewScoped
public class UserController implements Serializable {

    @Inject
    private UserService userService;

    private User currentUser;

    private String mail;
    private String pass;

    public UserController(){
        this.currentUser = new User();
    }

    public String index(){
        if(this.currentUser == null) {
            return "index_user";
        }

        return "user_profile";
    }

    public String login(){
        this.currentUser = this.userService.findByMailandPassword(this.mail, this.pass);

//        Repeat sequence
        return index();
    }
}
