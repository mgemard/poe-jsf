package poe.jsf.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import poe.dao.UserDao;
import poe.jpa.User;

@ManagedBean(name = "userListController")
@SessionScoped
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
}