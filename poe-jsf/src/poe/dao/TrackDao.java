package poe.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import poe.jpa.Track;

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
        System.out.println("I am in get track list() from TrackDao");
        return em.createQuery("SELECT u from Track u").getResultList();
    }

    public void delete(long trackId) {
        Track trackToDelete = em.find(Track.class, trackId);
        em.remove(trackToDelete);
    }

    public void delete(Track trackToDelete) {
        em.remove(trackToDelete);
    }

    public void update(Track track) {
        track = em.merge(track);
    }

    public Track get(long id) {
        return em.find(Track.class, id);
    }

}
