package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "userController")
@ManagedBean
@ViewScoped
public class UserController implements Serializable {

    @Inject
    private UserService userService;

    private User currentUser;

    public UserController(){
        this.currentUser = new User();
    }

    public String index(){
        if(this.currentUser.getId() == 0) {
            return "index_user";
        }

        return "user_profile";
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public String login(String mail, String pass){
        this.currentUser = this.userService.findByMailandPassword(mail, pass);

//        Repeat sequence
        return index();
    }
}
