package com.jennbowers.moviereviewer.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewername;
    private String rating;
    private int reviewerage;
    private String reviewergender;
    private String revieweroccupation;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review() {}

    public Review(String reviewername, String rating, int reviewerage, String reviewergender, String revieweroccupation, Movie movie) {
        this.reviewername = reviewername;
        this.rating = rating;
        this.reviewerage = reviewerage;
        this.reviewergender = reviewergender;
        this.revieweroccupation = revieweroccupation;
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getReviewerage() {
        return reviewerage;
    }

    public void setReviewerage(int reviewerage) {
        this.reviewerage = reviewerage;
    }

    public String getReviewergender() {
        return reviewergender;
    }

    public void setReviewergender(String reviewergender) {
        this.reviewergender = reviewergender;
    }

    public String getRevieweroccupation() {
        return revieweroccupation;
    }

    public void setRevieweroccupation(String revieweroccupation) {
        this.revieweroccupation = revieweroccupation;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
