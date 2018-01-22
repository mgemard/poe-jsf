package poe.jsf.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import poe.dao.UserDao;
import poe.jpa.User;
import poe.jsf.bean.UserBean;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private UserBean user;

    @EJB
    private UserDao userDao;

    public UserController() {
        user = new UserBean();
    }

    public String add() {
        System.out.println("adding user " + user.getEmail());
        User userJpa = new User();
        userJpa.setEmail(user.getEmail());
        userJpa.setPassword(user.getPassword());
        userDao.add(userJpa);
        show();
        return "home";
    }

    public void show() {
        System.out.println("user in form ");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        // enregistrer le user en bdd
        // afficher à l'utilisateur qu'on a bien pris
        // en compte son inscription
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        String outcome = "home"; // Do your thing?
//        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, outcome);
        
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}