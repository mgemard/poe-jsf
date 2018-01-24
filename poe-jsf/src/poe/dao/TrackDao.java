package poe.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import poe.jpa.Track;
import poe.jpa.User;

@Stateless
public class TrackDao {

    @PersistenceContext(unitName = "pu-h2")
    private EntityManager em;

    public long add(Track track) {
        System.out.println("em: " + em);
        em.persist(track);
        return track.getId();
    }

    public List<Track> list() {
        System.out.println("I am in getUsers() from UserDao");
        return em.createQuery("SELECT u from User u").getResultList();
    }

    public void delete(long userId) {
        Track userToDelete = em.find(Track.class, userId);
        em.remove(userToDelete);

    }

    public void delete(Track userToDelete) {
        em.remove(userToDelete);
    }

    public void update(Track user) {
        user = em.merge(user);
    }

    public Track get(long id) {

        return em.find(Track.class, id);
    }

}
