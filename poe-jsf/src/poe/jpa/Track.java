package poe.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToMany(mappedBy = "tracks")
    private List<User> artists;

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

    public List<User> getArtist() {
        if (artists == null ) {
            artists = new ArrayList<User>();
        }
        return artists;
    }

    public void setArtist(List<User> artist) {
        this.artists = artist;
    }

    public void addArtist(String artist2) {
        // TODO Auto-generated method stub
        
    }


}
