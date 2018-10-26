package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.User;
import be.thomasmore.travelmore.service.UserService;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    @Inject
    private UserService userService;

    private static User currentUser;
    private static String toolmessage;

    public UserController(){
        if(currentUser == null){
            currentUser = new User();
        }
    }

    public String index(){
        if(currentUser.getId() == 0) {
            return "index_user";
        }

        return "user_profile";
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public String getToolmessage(){
        return toolmessage;
    }

    public String login(String mail, String pass){
        try {
            currentUser = this.userService.findByMailandPassword(mail, pass);
            toolmessage = "";
        }catch (Exception e){
            toolmessage = "Something went wrong when logging in";
        }

//        Repeat sequence
        return index();
    }

    public String register(String mail, String pass, String name, String famname){
//        Logout old user
        this.logout();

//        Generate user
        User u = new User(name, famname, pass, mail);

//        Check if mail already in use
        boolean inuse = false;

        try {
            this.userService.findByMail(mail);
            inuse = true;
        }catch (Exception e) {}

//        Insert user
        if(!inuse) {
            try {
                this.userService.insert(u);
                toolmessage = "";
            } catch (Exception e) {
                toolmessage = "Something went wrong registering " + e.getStackTrace().toString();
            }
        }else {
            toolmessage = "Mail already in use";
        }

//        Repeat sequence
        return index();
    }

    public String logout(){
//        Clear user
        currentUser = new User();

//        Repeat sequence
        return index();
    }
}
