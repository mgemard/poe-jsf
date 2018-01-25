package poe.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    
    @ManyToOne
    private User user;

//  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tracks")

    public Track() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
//    public List<User> getArtist() {
//        if (artists == null ) {
//            artists = new ArrayList<User>();
//        }
//        return artists;
//    }
//
//    public void setArtist(List<User> artist) {
//        this.artists = artist;
//    }
//
//    public void addArtist(String artist2) {
//        // TODO Auto-generated method stub
//    }
    
}
