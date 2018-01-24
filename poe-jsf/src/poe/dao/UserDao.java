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

    public long add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
        return user.getId();
    }

    public List<User> list() {
        System.out.println("I am in getUsers() from UserDao");
        return em.createQuery("SELECT u from User u").getResultList();
    }

    public void delete(long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);
    }

    public void delete(User userToDelete) {
        em.remove(userToDelete);
    }

    public void update(User user) {
        user = em.merge(user);
    }

    public User get(long id) {
        return em.find(User.class, id);
    }

}
