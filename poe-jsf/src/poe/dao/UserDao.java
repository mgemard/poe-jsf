package poe.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import poe.jpa.User;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "pu-h2")
    private EntityManager em;

    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }

    public List<User> getUsers() {
        System.out.println("I am in getUsers() from UserDao");
        return em.createQuery("SELECT u from User u").getResultList();
    }

    public void delete(long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);

    }
    public void deleteEntity(User userToDelete) {
        em.remove(userToDelete);
    }

}
