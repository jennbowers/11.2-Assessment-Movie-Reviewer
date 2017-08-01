package com.jennbowers.moviereviewer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private String imdblink;
    private String releasedate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Movie() {}

    public Movie(String title, String genre, String imdblink, String releasedate) {
        this.title = title;
        this.genre = genre;
        this.imdblink = imdblink;
        this.releasedate = releasedate;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdbLink() {
        return imdblink;
    }

    public void setImdbLink(String imdblink) {
        this.imdblink = imdblink;
    }

    public String getReleaseDate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }
}
