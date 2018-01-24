package poe.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import poe.dao.UserDao;
import poe.jpa.User;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;
    private List<User> userList;

    @EJB
    private UserDao userDao;

    public UserController() {
        user = new User();
    }

    public List<User> getUserList() {

        userList = userDao.list();
        System.out.println("I am in getUserList() from controller");
        System.out.println(userList.size());
        return userList;
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
        // FacesContext facesContext = FacesContext.getCurrentInstance();
        // String outcome = "home"; // Do your thing?
        // facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,
        // null, outcome);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String delete(long id) {
        this.userDao.delete(id);
        return "home";
    }

    public String showUpdatePage(long id) {
        this.user = this.userDao.get(id);
        return "edit";
    }

    public String update() {
        userDao.update(this.user);
        return "home";
    }

}