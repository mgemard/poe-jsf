package poe.jsf.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import poe.dao.UserDao;
import poe.jpa.User;

@ManagedBean(name = "userListController")
@RequestScoped
public class UserListController {
    @EJB
    private UserDao userDao;

    private List<User> userList;

    public List<User> getUserList() {

        userList = userDao.getUsers();
        System.out.println("I am in getUserList() from controller");
        System.out.println(userList.size());
        return userList;
    }

    public String delete(long userId) {
           userDao.delete(userId);
           return "home";
//           FacesContext facesContext = FacesContext.getCurrentInstance();
//           String outcome = "home"; // Do your thing?
//           facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, outcome);
//           
    }

}