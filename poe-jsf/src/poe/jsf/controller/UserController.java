package poe.jsf.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import poe.jsf.bean.UserBean;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private UserBean user;

    public UserController() {
        user = new UserBean();
    }

    public void add() {
        System.out.println("adding user " + user.getEmail());
    }

    public void show() {
        System.out.println("user in form ");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        // enregistrer le user en bdd
        // afficher à l'utilisateur qu'on a bien pris
        // en compte son inscription
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String outcome = "home"; // Do your thing?
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, outcome);
        
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

}