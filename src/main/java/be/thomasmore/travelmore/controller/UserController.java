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

    public UserController(){ }

    public String index(){
        if(currentUser == null) {
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
//        Generate user
        User u = new User(name, famname, pass, mail);

//        Insert user
        try {
            this.userService.insert(u);
            toolmessage = "";
        }catch (Exception e){
            toolmessage = "Something went wrong when logging in";
        }

//        Repeat sequence
        return index();
    }
}
